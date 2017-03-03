package com.example.desarrollo7.myapplication.rest.api

/**
 * Created by desarrollo7 on 2/03/17.
 */

object JsonKeys {
    /**
     * General Json Keys
     */
    val MESSAGE = "message"
    val ERROR = "error"
    val RESPONSE = "response"
    val CODE = "code"
    val DATA = "data"
    val RESULTS = "results"

    /**
     * Marvel Character
     */
    val CHARACTER_ID = "id"
    val CHARACTER_NAME = "name"
    val CHARACTER_DESCRIPTION = "description"

    val CHARACTER_COMICS_OBJECT = "comics"
    val CHARACTER_TOTAL_COMICS = "available"
    val CHARACTER_COMICS_RESOURCE_URI = "resourceURI"
    val CHARACTER_COMICS_NAME = "name"
    val CHARACTER_COMICS_ARRAY = "items"

    val CHARACTER_SERIES_OBJECT = "series"
    val CHARACTER_TOTAL_SERIES = "available"
    val CHARACTER_SERIES_RESOURCE_URI = "resourceURI"
    val CHARACTER_SERIES_NAME = "name"
    val CHARACTER_SERIES_ARRAY = "items"

    val CHARACTER_STORIES_OBJECT = "stories"
    val CHARACTER_TOTAL_STORIES = "available"
    val CHARACTER_STORIES_RESOURCE_URI = "resourceURI"
    val CHARACTER_STORIES_NAME = "name"
    val CHARACTER_STORIES_TYPE = "type"
    val CHARACTER_STORIES_ARRAY = "items"

    val CHARACTER_EVENTS_OBJECT = "events"
    val CHARACTER_TOTAL_EVENTS = "available"
    val CHARACTER_EVENTS_RESOURCE_URI = "resourceURI"
    val CHARACTER_EVENTS_NAME = "name"
    val CHARACTER_EVENTS_ARRAY = "items"

    val CHARACTER_URLS_URL = "url"
    val CHARACTER_URLS_TYPE = "type"
    val CHARACTER_URLS_ARRAY = "urls"


    val CHARACTER_THUMBNAIL = "thumbnail"
    val CHARACTER_THUMBNAIL_PATH = "path"
    val CHARACTER_THUMBNAIL_EXT = "extension"
    /**
     * Image Ratio
     */
    val CHARACTER_THUMBNAIL_RATIO_PORTRAIT_SMAILL = "portrait_small" //50x75px
    val CHARACTER_THUMBNAIL_RATIO_PORTRAIT_MEDIUM = "portrait_medium" //100x150px
    val CHARACTER_THUMBNAIL_RATIO_PORTRAIT_XLARGE = "portrait_xlarge" //150x225px
    val CHARACTER_THUMBNAIL_RATIO_PORTRAIT_FANTASTIC = "portrait_fantastic" //168x252px
    val CHARACTER_THUMBNAIL_RATIO_PORTRAIT_UNCANNY = "portrait_uncanny" //300x450px
    val CHARACTER_THUMBNAIL_RATIO_PORTRAIT_INCREDIBLE = "portrait_incredible" //216x324px


    val CHARACTER_THUMBNAIL_RATIO_LANDSCAPE_MEDIUM = "landscape_medium" //175x130px
    val CHARACTER_THUMBNAIL_RATIO_LANDSCAPE_XLARGE = "landscape_xlarge" //270x200px
    val CHARACTER_THUMBNAIL_RATIO_LANDSCAPE_AMAZING = "landscape_amazing" //250x156px
    val CHARACTER_THUMBNAIL_RATIO_LANDSCAPE_INCREDIBLE = "landscape_incredible" //464x261px


    /**
     * Db
     */
    val DB_NAME = "Marvel.db"

    /**
     * User
     */
    val USER_TABLE_NAME = "user"
    val USER_ID = "idUser"
    val USER_EMAIL = "email"
    val USER_PASSWORD = "password"
}