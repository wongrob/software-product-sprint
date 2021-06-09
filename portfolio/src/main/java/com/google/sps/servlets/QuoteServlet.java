package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String jsonString = "[ {\"quote\":\"Don't give up. Don't ever give up\",\"author\":\"Jim Valvano\"}, {\"quote\":\"A person who never made a mistake never tried anything new.\",\"author\":\"Albert Einstein\"}, {\"quote\":\"Compromise where you can. Where you can't, don't. Even if everyone is telling you that something wrong is something right. Even if the whole world is telling you to move, it is your duty to plant yourself like a tree, look them in the eye, and say 'No, you move'.\",\"author\":\"Peggy Carter, Captain America: Civil War\"} ]";

    response.setContentType("application/json;");
    response.getWriter().println(jsonString);
  }
}
