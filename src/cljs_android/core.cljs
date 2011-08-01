(ns cljs-android.core)

(js* "load(\"/sdcard/com.googlecode.rhinoforandroid/extras/rhino/android.js\")")
(def Android  (js* "Android"))

(defn ^:export greet []
  (let [droid (Android.)]
    (.makeToast droid "Hello World")))
(greet)

