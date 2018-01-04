# Java UMDIO Wrapper

A Java wrapper for the umd.io API wrapper

## More Information

The API (umd.io) gives users the ability to get course information, busses, campus locations, and other various information for UMD. I'm in the process of creating a Java wrapper for all of this information. This is a large project, and features will be added continuously.

## Current Features

* Search courses by course ID and department ID
* Get all available information about a course

## Getting Started

As of right now, I haven't built the JAR or added a way to easily take advantage of the wrapper as this is still heavily in development. However, you can follow the process here

However, below is the code to get started
```
CourseSearch search = new CourseSearch();
```

Then the various methods to get the course information will be in the javadoc located here (TODO)

## TODO

* Add search by semester, geneds, and other various parameters
* Build final JAR once most of the API function has been fulfilled
* Add javadoc

## Built With

* [Gson](https://github.com/google/gson) - Google JSON 
* [umd.io](http://umd.io) - UMD API