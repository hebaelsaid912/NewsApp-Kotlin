# NewsApp-Kotlin


[![API](https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=26)

NewsApp is an android app, this app for presenting news feeds from reddit news about Kotlin. This application using the API from  https://www.reddit.com/
## Code Installation

You can clone code and run it using :

``
  IDE : Android Studio
  Android Gradle Plugin Version : 7.3.0
  Gradle Version : 7.4
  Compile Sdk : 32
  Java: 11
``

## Features
- List all Kotlin news from https://www.reddit.com 
- App Allow to show news details

## App ScreenShots 

| | | |
|:-------------------------:|:-------------------------:|:-------------------------:|
|![photo_2022-11-16_15-11-28](https://user-images.githubusercontent.com/72816466/202192094-f6f21d84-d30a-4ebd-83f0-628511d54342.jpg)
| ![photo_2022-11-16_15-11-30](https://user-images.githubusercontent.com/72816466/202192206-15d04dac-3130-4023-a778-9ac69f85e3b4.jpg)
|![photo_2022-11-16_15-11-29 (2)](https://user-images.githubusercontent.com/72816466/202192291-1b393f60-3080-429b-afb5-3ffd8278e858.jpg)
|![photo_2022-11-16_15-11-29](https://user-images.githubusercontent.com/72816466/202192367-b2faa989-f286-4f75-a90c-ac714797857b.jpg)
|![photo_2022-11-16_15-11-30 (2)](https://user-images.githubusercontent.com/72816466/202192426-4b28544e-c4d2-45d5-a490-b2c19c49a983.jpg)
|  ![photo_2022-11-16_15-11-30 (3)](https://user-images.githubusercontent.com/72816466/202192471-deba28f6-c471-4312-9f49-53986775b1f1.jpg)
|![photo_2022-11-16_15-11-31](https://user-images.githubusercontent.com/72816466/202192514-2bb0ea64-1772-4f6b-9345-982ade36f27d.jpg)|

## Architecture
The following diagram shows all the modules and how each module interact with one another after. This architecture using a layered software architecture. 

![81968739-a8bec700-95d1-11ea-8682-48fe879c25ff](https://user-images.githubusercontent.com/72816466/202192619-d33e98f8-f5a8-4f99-bf7f-332046446279.png)

## Tech stack & Open-source libraries
- Minimum SDK level 26
- Kotlin based
- Android Gradle plugin requires Java 11 to run.
- Architecture
    - MVVM Architecture ( DataBinding - ViewModel ).
    - Single Activity 
       - multiple Fragment handled together using Navigation.
    - Repository Design Pattern 
- Retrofit2 & Gson - construct the REST APIs.
-  Coroutines for asynchronous.
- Glide for image loading
- Scalable Unit 
  - text size.
  - unit size.
- Dependency Injection (dagger-hilt).
