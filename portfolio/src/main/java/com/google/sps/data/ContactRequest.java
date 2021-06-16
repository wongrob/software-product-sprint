package com.google.sps.data;

/** An item on a todo list. */
public final class ContactRequest {

  private final long id;
  private final String name;
  private final String email;
  private final String phone_number;
  private final String inquiry;
  private final long timestamp;

  public ContactRequest(long id, String name, String email, String phone_number, String inquiry, long timestamp) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone_number = phone_number;
    this.inquiry = inquiry;
    this.timestamp = timestamp;
  }
}