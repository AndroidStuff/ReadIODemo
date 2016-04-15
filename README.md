# ReadIODemo

## About

Demo varied Read IO options (Text, JSON and XML files) with Android libraries

## Steps to reading a Text file
* Get a handle to `AssetManager` using `getAssets()`
* Open file in `assets` folder using the `AssetManager.open(filename)` method
* Rest of the stuff is the routine core java library API stuff; you read using `BufferedReader` and loop through the contents using `readLine()`

## Steps to reading an JSON file
* Same as the above steps to reading a Text File.
* To further parse through the json content, we use `JSONArray` and `JSONObject` classes provided by the Android SDK

## Steps to reading a XML file
* Same as the above steps to reading a Text File.
* To further parse through the XML content, we can use `DocumentBuilder` (aka DOM parse) or `SAXParser` classes that comes bundled under javax.xml.parsers package. There is an other Android Docs recommended alternative, that we use here in this demo project, that is to use the `XmlPullParser` 

## Resources/References
* The sample text in sample_text.txt is a generated one, got from the website [BlindTextGenerator.com](http://www.blindtextgenerator.com/lorem-ipsum). Try it to <3 it :)
* There are a few good options when it comes to generating sample JSON data. You could use either [GenerateData.com](http://www.generatedata.com/) or [JSON-Generator.com](http://json-generator.com).
* [Android API Reference Documentation](http://developer.android.com/reference/packages.html)
* [Android's Training on Parsing XML Data](http://developer.android.com/training/basics/network-ops/xml.html)