Far citizen  is an Android application

 [<img src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" alt="Get it on Google Play" height="60">](https://play.google.com/store/apps/details?id=ms.messageapp.alpha&hl=en&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1)


Build instructions
==================

This client is a standard android studio project.

If you want to compile it in command line with gradle, go to the project directory:

Debug mode:

`./gradlew assembleDebug`

Release mode:

`./gradlew assembleRelease`

And it should build the project (you need to have the right android SDKs)

Recompile the provided aar files until we have gradle
======================================================

generate olm-sdk.aar
--------------------

sh build_olm_lib.sh

generate matrix-sdk.aar
----------------------

sh build_matrix_sdk_lib.sh

generate the other aar files
----------------------

sh build_jitsi_libs.sh

compile the matrix SDK with the Far Citizen-android project
----------------------

sh set_debug_env.sh

Make your own flavour
=====================

Let says your application is named MyRiot : You have to create your own flavour.

Modify riot-android/vector/build.gradle
---------------------------------------

In "productFlavors" section, duplicate "app" group if you plan to use FCM or "appfdroid" if don't.

for example, with FCM, it would give

```
     app {
            applicationId 'ms.messageapp.alpha'
            // use the version name
            versionCode rootProject.ext.versionCodeProp
            versionName rootProject.ext.versionNameProp
            buildConfigField "boolean", "ALLOW_FCM_USE", "true"
            buildConfigField "String", "SHORT_FLAVOR_DESCRIPTION", "\"G\""
            buildConfigField "String", "FLAVOR_DESCRIPTION", "\"GooglePlay\""
        }
```

- if you use FCM, duplicate appImplementation at the end of this file and replace appImplementation by appmyriotImplementation.
- if you don't, update the "if (!getGradle().getStartParameter().getTaskRequests().toString().contains("fdroid"))" to include your flavor.

Create your flavour directory
-----------------------------

- Copy riot-android/vector/src/app or appfroid if you use FCM or you don’t.
- Rename it to appmyriot.
- If you use FCM, you will need to generate your own google-services.json.

Customise your flavour
----------------------

- Open riot-android/vector/src/appmyriot/AndroidManifest.xml
- Change the application name to myRiot with "android:label="Far Citizen" and "tools:replace="label"" in the application tag.
- Any other field can be customised by adding the resources in this directory classpath.
- Open Android studio, select your flavour.
- Build and run the app : you made your first Far Citizen app.

You will need to manage your own provider because "im.vector" is already used (look at VectorContentProvider to manage it).

FAQ
===

1. What is the minimum android version supported?

    > the mininum SDK is 16 (android 4.1)

2. Where the apk is generated?
riot-android-develop (1)\riot-android-develop\vector\app\release


3. How to make release apk ?

  * if you want to update the app and make new apk just following the steps  go to riot android develop "build.gradle"
     and change these: 
    versionCodeProp = 3
    versionNameProp = "0.3.26-dev"
  * by increasing the version code plus one or any number that can't be used in another copy apk for the app
	and then click sync  and wait for finish sync 
	
  *   After finish go to build menu and choose generate signed apk  then choose apk the  screen appear and choose the .jks file
	 that you have,  put the password and the key  then clcik next then choose app Release and choose the two option the full apk           and jar file and wait to finish building the app after finish you can find the apk.
  *  when error find make clean project then rebuild the project after finish click locate  to find the apk  
     app> relese> vector-app-release  then You can save the location or copy it in any place  then go to google play console 
	  choose the app ,Release managment  then create release and upload  the release and wait to finish uploadin  after finish must     the verison be different from the previous.
	  
