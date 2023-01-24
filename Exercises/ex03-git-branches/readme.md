### Exercise 03 - Git Branches (for Good Design)

You are going to work in a team of 3 to create a todo list (a.k.a. issues) then redesign and refactor the Cart code from Lab 1. You will learn about git branches and git merge.

A guide: https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell

### Use Case of the System

Context:
- There is an inventory of Items. 
- There is a database of Customers.

A Cart is started and items are added to the cart. The cart keeps an on-going total of the items in the cart. When done shopping, there is a checkout process that is initiated through the cart. An order is created in the cart and returned. A receipt of the order is printed.

UML and description here: https://docs.google.com/document/d/1LzjLWhJ1Sa6vjEQk22-zFDsl8vs3vrkERd6Cwq0GLnI/edit?usp=sharing


### Adding Issues to Git Repository

1. One person in your group create a git repository (you can keep it public). Check the box to include a repo and a .gitignore (with a Java template). Include your partners as collaborators (under Settings-Collaborators), giving them .

2. The others should clone the repo (use the https: not git).

<hr>

You will probably have to set up an access token for github. 

1. Go to the green circle in the upper right and choose Settings. 
2. Scroll to the bottom of the menu on the left and choose "Develop settings".
3. Under Personal access tokens, choose *Tokens (classic)
4. Generate new token.
5. Copy the token. It only appears this one time, so save it somewhere.
6. Use the copied token for your password.

<hr>

3. Someone add these Cart files to the repo. 

4. In your repo, click the "issues" tab along the top, then select green "New issue" button. Give it a title (you can add the comments that are in the sample repo or leave it blank). See https://github.com/lars1050/git-branch-practice for sample issues. 

Add the following issues:

1. Create class Item
2. Refactor CartItem
3. Create class Customer
4. Refactor Order: modify customer
5. Refactor member variables in Cart
5. Refactor Cart: create add() method
6. Refactor Cart: Create checkout() method
8. Refactor Order: Create receipt() method
9. Modify Main to use and test the classes


### Create dev branch

Branches are an essential part of code development. They are copies of the code that can be developed, improved, and tested before being incorporated back into the functioning code. One way to use branches is to keep the _main_ branch as release-able code only. A dev (or development) branch is where code modification really happens. For each issue (e.g. a feature enhancement, bug fix, or refactor), a branch is made off of the dev branch to modify the code, then incorporated back into dev when done. Once everything is ready (and tested) on the dev branch, it is merged into the main branch and ready for release.

To create a new branch, ONE PERSON in your group navigate to your repo and do the following:

```
git checkout -b dev
git push --set-upstream origin dev
```

That's it! You will not see any changes to your files, but you have just made a copy of the repo. Any changes that you make here will not impact the original files on the main branch.

> The use of `-b` is for making a new branch. Once the branch exists, you can checkout different branches (without the `-b` flag) to return to differnt states of your code. The second line essentially connects your local branch to the original repo on the server.

Now have the other members checkout the branch with this command:

```
git checkout dev
```

> Go to github and select the pull-down menu tab that says "main" and you will now see your dev branch.

### Addressing the issues

Have 1 person work on issue #1 (create class Item) and another on issue #3 (create class Customer). Other issues rely on these changes, so let's do these first. The third person can help both.

From the dev branch, you want to create an "issues" branch, and it is nice to have the issue number included. For example, you might choose "issue1-class-Item" or simply "issue1".

The one person create a branch for issue 1.

```
git checkout -b issue1-class-Item
git push --set-upstream origin issue1-class-Item
```

Everyone else can pull to incorporate the branch. Then repeat for issue #3.

```
git checkout -b issue3-class-Customer
git push --set-upstream origin issue3-class-Customer
```

Everyone else can pull to incorporate the branch.

Each person develops the code on their respective branches. Once you have made the changes and **the code is compiling**, merge the changes into the dev branch. Here is the example for issue1:

```
git checkout dev
git merge issue1-class-Item
git add *
git push
```

> The first line above reverts your local view to the what is in the _dev_ branch. Feel free to checkout the different branches at the command line and see how the files change. Everything is there in all the branches, but you only see 1 branch at a time. 

You will want to merge issue3 into the dev branch as well.  

Look at github to see the changes. Everyone can pull to incorporate the changes.

Finally, go to the list of issues on github and check that the issues are complete.

> There is a way to automate this process based on branch naming. Maybe we will look at this at another time.

Now you are ready to repeat the process!

### More Issues

As you choose which issues to divide and conquer in your group, keep in mind that you do not want 2 people editing the same file at the same time, since that is likely to lead to merge conflicts. Here is a possible plan.

These issues can now be developed independently without breaking the code:
- issue2 Refactor CartItem
- issue4 Refactor Order: modify customer
- issue9 Modify Main for using and testing the class

Once issue 2 is complete,
- issue5 Refactor member variables in Cart

Once issue 4 is complete,
- issue8 Refactor Order: Create receipt() method

Once issue 5 is complete,
- issue6 Refactor Cart: create add() method

Once issue 6 is complete,
- issue7 Refactor Cart: Create checkout() method

And keep developing Main to try out the new classes. _Of course, this is where Unit Testing would come in! The unit tests would be developed along with the code and used to confirm the class is functional before merging it back into the dev branch._



