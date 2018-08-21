## AndroidCodeTest
Rockspin Android code test

# Instructions 

Fork the source code from Github. When done, provide us with a link to your repository.

This is an Android Studio project which builds an app that fetches data for the first spacewalks that ever happened. This is taken from a simple NASA provided API in a JSON format.

An engineer started developing it, but has left it in a poor state. It doesn't compile and there are a couple of crashes. On top of that, it doesn't meet the necessary specifications. 

Below you will find a task list of the requirements this app has to fulfil:
- [ ] **Fix** any compile and crash **bugs**.
- [ ] Currently, the list only displays the purpose of each spacewalk. The data also provides the date when it happened. **Display the date on each item.** We leave it up to you to decide how best to show it.
- [ ] The spacewalk list is displayed in ascending order by date. **When the button in the bottom right is clicked the list should be displayed in descending order.** Clicking it again should reverse that - it should act as a toggle.
- [ ] The app should **support orientation changes** without reloading the data and without using android:configChanges.
- [ ] **Add a separator** in between the list items.

This is your opportunity to show us how you think and Android app should be architected, please make any changes you feel would benefit the app. 

You may include 3rd party libraries, but please state your reason for using them. The project currently depends on Retrofit and GSON for setting up a quick networking layer. Previous knowledge of these libraries isn't a requirement but may help you while doing the test.

# Optional stretch tasks (in progressive order):
- [ ] **Display a progress bar** while the items are initially fetched and animate the list when it loads. 
- [ ] Whenever **sorting** is changed **animate** the transition
- [ ] Introduce a [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) to `MainActivity` that handles the business logic and test it. 
