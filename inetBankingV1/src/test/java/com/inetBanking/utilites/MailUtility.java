package com.inetBanking.utilites;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MailUtility {

	public JSONArray emailsList;

	public MailUtility() throws IOException, InterruptedException, ParseException {
		String emailEndPoint = "https://api.testmail.app/api/json?apikey=b251e48e-4517-44f8-851d-ace9eda8d054&namespace=riae9&pretty=true";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json")
				.uri(URI.create(emailEndPoint)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		// System.out.println(response.body());
		JSONParser jsonParser = new JSONParser();
		JSONObject jobj = (JSONObject) jsonParser.parse(response.body());
		JSONArray emailsArray = (JSONArray) jobj.get("emails");
		this.emailsList = emailsArray;

	}

	public String getEmailSubject() throws IOException, InterruptedException, ParseException {

		JSONObject firstEmail = (JSONObject) emailsList.get(0);
		String emailSubject = (String) firstEmail.get("subject");
		// System.out.println("The email Subject is "+emailSubject);
		return emailSubject;

	}

	public String getCCList() throws IOException, InterruptedException, ParseException {

		JSONObject firstEmail = (JSONObject) emailsList.get(0);
		String ccList = (String) firstEmail.get("cc");
		// System.out.println("The email Subject is "+emailSubject);
		return ccList;

	}

	public int getAttachmentFilesNumber() throws IOException, InterruptedException, ParseException {

		JSONObject firstEmail = (JSONObject) emailsList.get(0);
		JSONArray attachmentArray = (JSONArray) firstEmail.get("attachments");
		return attachmentArray.size();

	}

	public String getAttachmentFileNameOf(int attachmentNumber)
			throws IOException, InterruptedException, ParseException {

		JSONObject firstEmail = (JSONObject) emailsList.get(0);
		JSONArray attachmentArray = (JSONArray) firstEmail.get("attachments");
		JSONObject attachment = (JSONObject) attachmentArray.get(attachmentNumber);
		return (String) attachment.get("filename");

	}

	public String getAttachmentContentType(int attachmentNumber)
			throws IOException, InterruptedException, ParseException {

		JSONObject firstEmail = (JSONObject) emailsList.get(0);
		JSONArray attachmentArray = (JSONArray) firstEmail.get("attachments");
		JSONObject attachment = (JSONObject) attachmentArray.get(attachmentNumber);
		return (String) attachment.get("contentType");

	}

	public boolean verifyTheMailBodyHas(String textToMatch) {
		JSONObject firstEmail = (JSONObject) emailsList.get(0);
		String htmlBodyString = (String) firstEmail.get("html");
		System.out.println("Has matched "+htmlBodyString);
		Pattern pattern = Pattern.compile(textToMatch);
		Matcher matcher = pattern.matcher(htmlBodyString);
		System.out.println("Has matched "+matcher.matches());
		return matcher.matches();

	}

}
