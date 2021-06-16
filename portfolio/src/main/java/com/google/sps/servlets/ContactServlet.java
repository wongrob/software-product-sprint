package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Datastore for persistent storage
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

// Jsoup for cross-site-scripting (XSS)
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/contact-form")
public class ContactServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the values entered in the form.
    String name = Jsoup.clean(request.getParameter("name-input"), Whitelist.none());
    String email = Jsoup.clean(request.getParameter("email-input"), Whitelist.none());
    String number = Jsoup.clean(request.getParameter("number-input"), Whitelist.none());
    String inquiry = Jsoup.clean(request.getParameter("inquiry-input"), Whitelist.none());

    if (number.isEmpty()) {
        number = "N/A"; // Provide a value for someone who didn't add a number
    }

    // Get timestamp because maybe it will be useful
    long timestamp = System.currentTimeMillis();

    // Store the values into datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("ContactRequest");
    FullEntity contactRequestEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name", name)
            .set("email", email)
            .set("phone_number", number)
            .set("inquiry", inquiry)
            .set("timestamp", timestamp)
            .build();
    datastore.put(contactRequestEntity);

    // Print the value so you can see it in the server logs.
    /*StringBuilder contactRequest = new StringBuilder();
    contactRequest.append("Contact Request: " + name + " would like you to contact them at " + email);
    if (!number.isEmpty()) {
        contactRequest.append(" or " + number); // Include number only if provided
    }
    contactRequest.append(" regarding: " + inquiry);
    System.out.println(contactRequest);*/

    //Redirect user after submitting
    response.sendRedirect("/index.html");
  }
}