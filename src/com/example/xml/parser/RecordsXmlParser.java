package com.example.xml.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.dto.Record;

import android.util.Xml;

public class RecordsXmlParser {

	// For the purpose of this demo, we're not using a Namespace
	private static final String NAMESPACE = null;
	private static final String RECORDS_TAG = "records";
	private static final String RECORD_TAG = "record";
	private static final String ID_TAG = "id";
	private static final String NAME_TAG = "name";
	private static final String EMAIL_TAG = "email";
	private static final String COMPANY_TAG = "company";

	public List<Record> parse(InputStream in) throws XmlPullParserException, IOException {
		XmlPullParser parser = Xml.newPullParser();

		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
		parser.setInput(in, null);
		parser.nextTag();
		return parseRootTag(parser);
	}

	public List<Record> parse(Reader in) throws XmlPullParserException, IOException {
		XmlPullParser parser = Xml.newPullParser();

		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
		parser.setInput(in);
		parser.nextTag();
		return parseRootTag(parser);
	}

	private List<Record> parseRootTag(XmlPullParser parser) throws XmlPullParserException, IOException {
		List<Record> records = new ArrayList<Record>();

		// Quicktest to ensure that the root tag and Namespace requirements
		// match before processing.
		// Throws error when the requirements fail
		parser.require(XmlPullParser.START_TAG, NAMESPACE, RECORDS_TAG);

		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			// Starts by looking for the 'record' tag
			if (name.equals("record")) {
				records.add(parseRecordTag(parser));
			} else {
				skip(parser);
			}
		}
		return records;
	}

	private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
		if (parser.getEventType() != XmlPullParser.START_TAG) {
			throw new IllegalStateException();
		}
		int depth = 1;
		while (depth != 0) {
			switch (parser.next()) {
			case XmlPullParser.END_TAG:
				depth--;
				break;
			case XmlPullParser.START_TAG:
				depth++;
				break;
			}
		}
	}

	private Record parseRecordTag(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACE, RECORD_TAG);
		Record record = new Record();
		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			// Starts by looking for the 'record' tag
			if (name.equals(ID_TAG)) {
				record.setId(parseIDTag(parser));
			} else if (name.equals(NAME_TAG)) {
				record.setName(parseNameTag(parser));
			} else if (name.equals(EMAIL_TAG)) {
				record.setEmail(parseEMailTag(parser));
			} else if (name.equals(COMPANY_TAG)) {
				record.setCompany(parseCompany(parser));
			} else {
				skip(parser);
			}
		}
		return record;
	}

	private String parseEMailTag(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACE, EMAIL_TAG);
		String text = readText(parser);
		parser.require(XmlPullParser.END_TAG, NAMESPACE, EMAIL_TAG);
		return text;
	}

	private String parseCompany(XmlPullParser parser) throws XmlPullParserException, IOException {
		return parseXmlTagWithTextContentOnly(parser, COMPANY_TAG);
	}

	private String parseNameTag(XmlPullParser parser) throws XmlPullParserException, IOException {
		return parseXmlTagWithTextContentOnly(parser, NAME_TAG);
	}

	private String parseIDTag(XmlPullParser parser) throws XmlPullParserException, IOException {
		return parseXmlTagWithTextContentOnly(parser, ID_TAG);
	}

	private String parseXmlTagWithTextContentOnly(XmlPullParser parser, String tagName)
			throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACE, tagName);
		String text = readText(parser);
		parser.require(XmlPullParser.END_TAG, NAMESPACE, tagName);
		return text;
	}

	private String readText(XmlPullParser parser) throws XmlPullParserException, IOException {
		String result = "";
		if (parser.next() == XmlPullParser.TEXT) {
			result = parser.getText();
			parser.nextTag();
		}
		return result;
	}

}
