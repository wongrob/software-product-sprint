// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random fact to the page.
 */
function addRandomFact() {
  const facts =
      ['I am an Eagle Scout','I was a part of a documentary','I love to play video games','I am part of a club Ultimate team','I am a Marvel movie fan','I am a DC Arrowverse fan','My favorite color is red','I love the outdoors','I am a member of Phi Kappa Phi','I am a member of Eta Kappa Nu, Theta Kappa Chapter','I am a member of Tau Beta Pi, California Rho Chapter'];

  // Pick a random fact.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}


//fetches the quote from the QuoteServlet.java and displays on the page
async function showQuote() {
  const responseFromServer = await fetch('/quote');
  const textFromResponse = await responseFromServer.json();

  const quoteContainer = document.getElementById('quote-container');
  const rand = Math.floor(Math.random() * textFromResponse.length);
  quoteContainer.innerText = textFromResponse[rand].quote + " -" + textFromResponse[rand].author;
}

//outputs confirmation of form submitting
function confirm() {
    alert("Your form has been submitted and received. I will get back to you.");
}
