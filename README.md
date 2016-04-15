# ReadIODemo

## About

Demo varied Read IO options (Text, JSON and XML files) with Android libraries

## Steps to reading a Text file
* Get a handle to `AssetManager` using `getAssets()`
* Open file in `assets` folder using the `AssetManager.open(filename)` method
* Rest of the stuff is the routine core java library API stuff; you read using `BufferedReader` and loop through the contents using `readLine()`

## Steps to reading an XML file
* Same as the above steps to reading a Text File.
* To further Parse through the json content, we use `JSONArray` and `JSONObject` classes provided by the Android SDK

## Steps to reading a JSON file
* Same as the above steps to reading a Text File.


## Resources
* The sample text in sample_text.txt is a generated one, got from the website [BlindTextGenerator.com](http://www.blindtextgenerator.com/lorem-ipsum). Try it to <3 it :)
* There are a few good options when it comes to generating sample JSON data. You could use either [GenerateData.com](http://www.generatedata.com/) or [JSON-Generator.com](http://json-generator.com).
* [Android API Reference Documentation](http://developer.android.com/reference/packages.html)