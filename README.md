# The Comic App - Modern Android Architecture

The Comic App allow users to browse through [xkcd comics](https://xkcd.com/), see their description, search a comic and share with loved ones!

This project presents a modern approach to Android app development. The project tries to combine popular Android tools and to demonstrate best development practices by utilizing up to date tech stack like Jetpack Compose.

The app layers its presentation through MVVM presentation pattern.

## Features

- browse through the comics,
- see the comic details with description,
- search for comics by the comic number,
- get the comic explanation,
- send comics to others,

Coming in next update : )
- search for comics by text,
- favorite the comics, which would be available offline too,
- get notifications when a new comic is published,
- support multiple form factors.

## Screens

<p>
  <img src="demo/demo_gif_1.gif" width="320" height="660" />
  &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
  <img src="demo/demo_gif_2.gif" width="320" height="660" /> 
</p>

## Description

* UI 
   * [Compose](https://developer.android.com/jetpack/compose) declarative UI framework
   * [Material design](https://material.io/design)

* Tech/Tools
    * [Kotlin](https://kotlinlang.org/) 100% coverage
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) for async operations
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose) 
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that store/manage UI state
    * [Retrofit](https://square.github.io/retrofit/) for networking
    * [Coil](https://github.com/coil-kt/coil) for image loading
   
* Modern Architecture
    * Single activity architecture
    * MVVM for presentation layer ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel))
    * [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions
    
## Presentation pattern layers
* View - Composable screens that consume state, apply effects and delegate events upstream.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that manages and set the state of the corresponding screen. The ViewModel is scoped to the lifetime of the corresponding screen composable in the backstack.
* Model - Data source class for the comics.

## Next version!
- Favorite the comics and make them available offline:
  * Using room database, we can favorite comics for offline viewing.   
- Support multiple form factors:
  * Comics can be loaded in a list fashion using lazy column.
- Search for comics by text:
  * Although there are some [xkcd search engines](https://relevantxkcd.appspot.com/) available, there is no direct api for fetching a comic by text like we have for [ID](https://xkcd.com/2756/info.0.json). One solution is to built a web scraper that will go through xkcd website on fixed time intervals and save them in our backend database. Then app can perform text search and get ID of comic based on title/description. 
- Get notifications when a new comic is published,
  * Once web scraping engine is setup, a [FCM notification](https://firebase.google.com/docs/cloud-messaging) can be issued by server for new comics being added in database.


