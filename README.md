# <img src="https://swvl.com/assets/img/swvl-logo.svg" height=150 alt="SWVL Movies App" />
# SWVL Movies App

An android application developed as a technical challenge from SWVL.


![Version v1.0 Badge][version-badge] ![Android 30+ Badge][android-version-badge]

## Prerequisites

Use the latest Android Studio version. Use Android SDK version 30 to compile the code.

```bash
compileSdkVersion 30
buildToolsVersion "30.0.2"
minSdkVersion 16
targetSdkVersion 30
```

## Getting started

- Get this repo by cloning it through Android Studio's VCS or downloading it through this page and then importing it in Android Studio.

- Compile this application and let it download the required dependencies.

- If needed, upgrade the gradle to the required version.

## Other Information

- This application is developed while following the MVVM architecture as well as architectural components from `JetPack`.

- Movies are being fetched from JSON file which is placed under the `raw` folder.

- Flickr Photo Search API is used to get images.

## keystore.properties

You can create a release version of this application and all the information is placed under `keystore.properties` file.

[version-badge]: https://img.shields.io/badge/Version-v1.0-blue
[android-version-badge]: https://img.shields.io/badge/Android-30+-brightgreen
