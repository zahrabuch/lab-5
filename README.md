# Lab 4: Grade API program

**Please try to work through Tasks 0 and 1 ahead of your lab time on Monday.
Your team and TA can help you during the lab if you had any trouble,
so don't worry if you don't get through Task 1 before lab. There will also
be some time to do this as your TA helps everyone get into teams.**


## Task 0: Fork and clone this repo

1. As with the previous lab activities, start by making a fork of this repo and cloning it.

## Task 1: Your API Token (token)

In order to use the Grade API, you will need to sign up an account, and use the `token`..
To sign up an account, we are going to make a simple request to the Grade API.

1. Go to https://hoppscotch.io. This is a tool like Postman, which can be used to quickly interact with APIs.
2. Beside the word GET, replace `https://echo.hoppscotch.io/` with `http://vm003.teach.cs.toronto.edu:20112/signUp`.

Next, we need to specify the username which we want to sign up with. To do this, we add a parameter.

3. In the Parameters tab, choose `+ Add new` and set the parameter name to `username`.
4. For its value, choose whatever username you want to use. Make note of the name you choose, as you'll use it during the lab. (Don't worry, you can repeat this process with a new username if you need to later!)
5. Press the `Send` button to make the request. You may receive an error that the request didn't go through. Scroll down and select `proxy` as the middleware and press `Send` again. You should now see the result of the request.
6. If the username had been used before, you will see a response indicating that. Choose a new username and send the request again.
7. If the request is successfully sent, you will see a response that contains a `status_code` of value `200`. In this response, you will get two important fields -  `token` and `environment_variables`, whose values you will need later on in the activity.

You can also refer to https://www.postman.com/cloudy-astronaut-813156/csc207-grade-apis-demo/overview for the documentation of all API requests related to the Grade API.
Specifically, to learn more about the SignUp API request, refer to - https://www.postman.com/cloudy-astronaut-813156/csc207-grade-apis-demo/request/9huifpg/1-1-sign-up-when-a-username-is-available

***

Alternative to the above: Enter `http://vm003.teach.cs.toronto.edu:20112/signUp?username=USERNAME` in any web browser
with `USERNAME` replaced with the username you want to use.

***

7. Create a new file called `username.txt` in the root directory of your project and copy / paste the value you found
   for the `token` field in that file. This file is indicated in the `.gitignore` for your project, so
   its name will appear yellow in IntelliJ to indicate that git will ignore the file (it won't be version
   controlled). This can be useful to ensure that you don't accidentally share private information
   (like personal api tokens) or configurations specific to your local environment when working on a
   team project.

Now that you have your api token, the last step is to get your program to use it. To do so, we
are going to set an environment variable in the run configuration.

Note: at this point you should be able to run the program, but it is possible that the Maven
project didn't automatically build. If you have errors which won't let you run the code in the
next step, you may need to reload the Maven project. You can do this by right-clicking on the
`pom.xml` file in your project. In the context menu, choose `Maven -> reload project`. This should
resolve any errors.

8. Try running the main application (`src/main/java/app/gui/Application`). When you start the program,
you will see that it says `your token is null` (since we didn't set it yet).
Stop the program and go to `Run -> Edit Configurations...`.

9. Open the Run Configuration for `Application` and find the `Environment Variables:`
field.
    - Note: If you don't see this Run Configuration listed:
      - create a new Run Configuration of type `Application` (use the +
      in the top left corner of the window).
      - where it says "Main class", type `app.gui.Application`.

10. In that field, paste the text you copied from `environment_variables` when you sign up an account. Your `token` should also be variable in `username.txt`.
Example: `token=6SgDAt8XpnQYTDPt4vHcPCCKJ2ppLg1C`.
11. Click `Apply` and then `OK`.
12. Now, rerun the program and you should see your `token` displayed.
13. Click on the `Log Grade` button and in the next screen, enter `207` as the course and a valid grade for this course. You should see a popup
telling you that your grade was successfully entered. You can then check your grade
by using the `Get Grade` menu and specifying your username and `207` for the course.

You are now ready to use the program! The following task will be completed with your
team during the lab. First, make sure everyone has successfully completed the steps above.

## Task 2: Forming a team

As a team-building exercise, you will now work together to form a team using
this application. Team members in this program are able to view the grades of other
team members.

1.  Choose a team name. Make it something unique to your team, as other teams will also
be picking team names and duplicate names aren't allowed.

2. Click on `Form a team` button. Have one member of your team form a team with the name your team chose.

3. Each other member of the team should then join the team using the `Join a team` menu. Make sure you see the popup
confirming that you successfully joined the team.

4. Try looking up the grade another team member entered for `207` using the `Get a Grade` menu.

Now that you are all on the team, there is one coding task for your team to work on today!

***

Note: If your team finds it convenient to work on parts of this lab on a common machine,
you can create different run configurations (copy an existing one) which each use a different
`token` environment variable. Then you can run multiple instances of the program and
enter requests as different users.

***

## Task 3: Coding the Get Average Grade feature

While this program has some useful core functionality which is provided by the Grade API,
there are certain things which the Grade API can't currently do.

1. Go to `My Team` menu, enter the course name as `207` and click on `Get average grade`. You will notice that the functionality 
for `Get Average Grade` isn't implemented yet and this throws an error. 
2. As a team, your goal is to work together to implement this feature and confirm that it works.
3. Follow the flow from the `getAverage` button defined in the UI layer (`app/gui/Application.java`) to reach until the 
`GetAverageGradeUseCase` in the usecase layer.
4. You will observe that the average calculation is already implemented in the `GetAverageGradeUseCase` class.
5. However, the `getMyTeam()` method is left unimplemented. Follow the hints provided in this method to complete its implementation.

## Task 4: Coding the Get Top Grade feature

In this task, you are required to build a feature that will allow the user to get the top grade of a course.

1. Similar to `Get Average Grade`, you will need to implement the `Get Top Grade` feature.
2. However, in this feature, the `Get Top Grade` usecase is already implemented in the `GetTopGradeUseCase` class.
3. You will need to implement the UI layer for this feature by adding a button `Get Top Grade` in the `My Team` menu.
You can draw inspiration from the `Get Average Grade` button.

Note: Your team can choose how you want to work on this part, but below is our suggestions.

Suggested logistics: One of you should invite the others to collaborate on their fork of the
original repo on GitHub. You can do this in your repo on GitHub under `Settings -> Collaborators`.
This will allow you to push branches to a common repo and then use pull requests to contribute
your code and review.

We recommend splitting the team into two halves with one half working on task 3 and the other on task 4. 
You can work on separate branches and merge the code together when you are done.
Note that successful completion of task 3 is a pre-requisite for task 4 as the `getMyTeam()` method is used in both the features. 

## Task 5 Bonus

If your team finishes the above task and has extra time, we encourage you think of an additional use-case that can be implemented 
using this Grade API. Implement this use-case end-to-end, from the UI layer to the UseCase layer, and see how it works.
This will be helpful for you when you start developing your own course project where you will also be using an API endpoint. 

## Tips
1. Use this API `info` if you want to access all the information you can access (your team and all your teammates' grades).
2. All responses are in `json` format. 
3. We are using a very simple authedication method, by passing `token` in the request headers. When you use some real-world APIs, you will see some more sophisticated authedication approches.
4. You can run the testing to check if your `GetAverageGradeUseCase` is implementated correctly, before you finish implmenting the API caller.
