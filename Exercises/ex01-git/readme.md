## Exercise 01: Working with a Git Code Repository

We will be using both GitHub and BitBucket for managing code in this course. Code that is being distributed to the class will be posted on Github (like this code). Code that students work on and share with others will be stored on BitBucket.

#### BitBucket

1. Go here and sign up for an account: https://bitbucket.org/product
1. Find a partner in the class.
1. One person makes a repository.

  - Please use the following naming convention:
    - BitBucket requires a project. Use csc395 and your username or last name for the project workspace name (e.g. csc395-larsonam or csc395-larson)
    - The repository will be a testing space. Use your username or last name and the word "sandbox" (e.g. larsonam-sandbox or sandbox-larson).

  - Include a readme.

  - Include a .gitignore.

  - In the advanced settings, choose Java.

1. Share the repository with your partner and with Dr. Larson (the invite button in the upper right).
1. Everyone navigate to a folder where you will be placing this repo.
1. Clone the bitbucket repo: `git clone https:...`

#### Github (everyone)

1. Navigate to a folder where you will be placing the github course repo.
1. Clone the github repo with `git clone git@github.com:lars1050/csc395-s23.git`
1. The person who did NOT make the BitBucket repo, they copy the folder ex01-git into the BitBucket repo.
1. Navigate to the ex01-git folder you just copied.
```
git add *
git commit -m "copying ex01 from github"
git push
```

Look at the repo on BitBucket and make sure your files are there.

1. The OTHER person navigates to inside the directory of the bitBucket repo.

```
git pull
```

And now you should both have the starter code for the exercise. Have 1 person create the class Checking and the other class Savings. If there are 3 of you, then another person can create a class IRA and add a test in Main (similar to the test for Checking and Savings). These classes `implements Account`.

Make sure your code compiles before you push it to the repo. You can just compile the one file with `javac Checking.java` or `javac Savings.java`. Then,

```
git add *
git commit -m "adding class Checking"
```

This has now saved your changes to your local repository, but the one on the server is unchanged.

1. One of you `git push` the changes to the repo.
1. The other `git pull` the changes from the server, then `git push` your changes.
1. Back to the first person and `git pull`.


Now everyone should have a working version of the complete code. Give it a test with `javac *.java` and `java Main`.

FINISHED!!

No need to submit anything because I have access to your BitBucket repo and can see the work that you did.
