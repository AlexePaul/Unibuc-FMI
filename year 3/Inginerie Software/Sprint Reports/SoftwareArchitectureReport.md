# Software Architecture Report

# Report date:
- 26.01.2024
- commit ID: b1c9a4abb03d4063b2737e3f5561a3f38b42d0d7

## Purpose of the software project:

- The purpose of our software project is to develop a mobile application for both Android and iOS platforms aimed at assisting individuals in quitting smoking. Drawing from our planning documentation, the primary objective is to provide users with a comprehensive tool that supports them throughout their journey to quit smoking effectively.

- Current Capabilities:
    - Track Quitting Plans: Users have the option to choose between two quitting plans: direct cessation of gradual reduction
    - Streak Tracking: For users opting for direct cessation, the app tracks the streak of consecutive days without smoking.
    - Longest streak: The app records the user's all time longest streak.
    - Money saved: The user can visualize the amount of money saved by not smoking in the current streak, reflecting the financial benefits of not smoking.
    - Gradual Quitting Plan: For users selecting the gradual quitting plan they are provided with a visualization of the recommended daily allowance of cigarrettes to smoke as they progress towards their quitting goals.
    - Comparison: The app tracks the actual amount of cigarretes smoked by users following the gradual quitting plan, allowing for a comparison with the recommended allowance.
    - Once every single day the user receives a notification from the app reminding them to stick to the plan.
    - There is also a Milestones section where the user can see the Milestones that he or she has achieved during their longest streak.

- Upcoming Capabilities:
    - Adding dark theme to our app
    - Completing the Milestones section by adding Achievements to make the app more interactive with the user

## Technologies used:
- **react-native** as our main framework for building the app.
- **firebase** as our cloud-based database and authentication service.
- **Figma** as our vector graphics program for designing the user interface.

## Guides:

### How to run the project locally:

- clone the project repository from [iQuit Repo](https://github.com/inginerie-software-2023-2024/proiect-inginerie-software-i-quit)
- navigate to the project directory in your terminal
- install dependencies using **npm install**
- run the project locally using **npm run android** for Android devices or **npm run ios** for iOS devices.
- this typically involves having a physical device or an emulator.

### How to build the project:
- install expo-cli using **npm install -g expo-cli**
- build the project using the command **expo build:<platform>** replacing the platform with iOS or Android.

### How to deploy the project:
- use the command **eas build** to initiate the process of building the app for iOS App Store or Android Google Play Store generating an AAB file or IPA file.

### How to contribute:
- Fork the project repository.
- Clone your forked repository to your local machine.
- Create a new branch for your contributions using a descriptive branch name
- Commit changes and push commits to your forked repository
- Submit a pull request to the original project repository


## Application Entry Points

### Data sources:
- We use **Cloud Firestore** as our primary data source for our app to leverage the benefits of a cloud-based database service

### Data inputs:
- Users interact with the application through input methods such as touch gestures and keyboard input.

### Configuration Files:
- **package.json** contains the names of all the dependencies used in the project.
- **babel.config.js** contains config options for Babel to transform ECMAScript into JS to include presets and plugins.
- **eas.js** contains config options for EAS for building, deploying the app, credentials and Expo EAS Workflows.
- **tsconfig.js** contains config options for TypeScript.
- **FirebaseConfig.js** contains config options for Firebase such as API keys, auth settings for our app.

### High level diagrams of the architecture:
- [User Journey](https://miro.com/app/board/uXjVNMGsbDA=/)
- [Product features](https://miro.com/app/board/uXjVNNFVqzU=/)
- [Activity diagram](https://app.creately.com/d/DQzkIuwU0PO/edit)


## Deployment plan:
- The application is deployed locally using Expo Go for testing
- We have created a workflow in github actions that is configured using a YAML file. The events that trigger the workflow are push and merge on the main branch.
- CI job: navigate to the iQuit folder, install the dependencies and run eventual tests.
- CD job: build and deploy the app using **eas build** on Expo Go. This will create .gradlew executable which will be converted into an Android/iOS release build.

## External dependencies:
- API: **Cloud Firestore** from **Firebase** as our cloud-based database service.
- Libraries: can be found in the **package.json** file.
