package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-form")
public class ContactServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the values entered in the form.
    String name = request.getParameter("name-input");
    String email = request.getParameter("email-input");
    String number = request.getParameter("number-input");
    String inquiry = request.getParameter("inquiry-input");

    // Print the value so you can see it in the server logs.
    StringBuilder contactRequest = new StringBuilder();
    contactRequest.append("Contact Request: " + name + " would like you to contact them at " + email);
    if (!number.isEmpty()) {
        contactRequest.append(" or " + number); // Include number only if provided
    }
    contactRequest.append(" regarding: " + inquiry);
    System.out.println(contactRequest);

    //Redirect user after submitting
    response.sendRedirect("http://rwong-sps-summer21.appspot.com/");
  }
}