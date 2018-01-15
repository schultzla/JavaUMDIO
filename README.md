# Java UMDIO Wrapper

A Java wrapper for the umd.io API wrapper

## More Information

The API (umd.io) gives users the ability to get course information, busses, campus locations, and other various information for UMD. I'm in the process of creating a Java wrapper for all of this information. This is a large project, and features will be added continuously.

## How To Implement

The jar is above in the repostiory (JavaUMDIO.jar). Add it as a dependency, and you will be able to use it. It is version 1.0 currently, it may not be updated with the newest features, however I will progressively rebuild it. Anything I add to the API from here on out will not be major, as most major functions have been added to the API. As of now, the only things you cannot do that the umd.io API can do is get bus and building information. All course and professor information should be accessible through the functions. Thanks!

## Current Features

* Search courses by various pre-set parameters, also giving the ability for custom parameters
* Get all available information about a course
* Get courses by professor

## Getting Started

```
CourseSearch search = new CourseSearch();
```

Then the various methods to get the course information will be in the javadoc located [here](https://schultzla.github.io/JavaUMDIO/)

## TODO

* Add more searchable params
* Add building API functionality

## Built With

* [Gson](https://github.com/google/gson) - Google JSON 
* [umd.io](http://umd.io) - UMD API
