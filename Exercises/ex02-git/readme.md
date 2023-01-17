## Exercise 02: Merge Conflicts and .gitignore

In this exercise, you will work with your previous partner to learn what happens and how to fix a merge conflict. Additionally, you will see how to remove files from your repo and how to ignore certain types of files in your repo.

<hr>

#### Creating Merge Conflicts

One of the powerful features of _git_ is its ability to merge together the work from different sources. As long as each contributor is committing changes to different parts of the code, there is no problem. However, if the same file is edited at the same line but not the same value, it results in a _merge conflict_. Let's create a merge conflict.

1. In the class Checking, each of you add this Javadocs to the method deposit:
  ```
  /** Adding specified amount to the balance. */
  ```
2. In the class Checking, ONE of you add this Javadocs to the method withdrawal:
  ```
  /** Subtracting specified amount from the balance (if sufficient balance) */
  ```
3. THE OTHER person add this Javadocs to the method withdrawal:
  ```
  /** If sufficient balance, subtract the specified amount. */
  ```
4. One person add, commit, and push the changes.
  ```
  git add *
  git commit -m "adding javadocs"
  git push
  ```

5. The OTHER PERSON attempt to add, commit and push the changes.

You have now succesfully created a conflict (or at least I hope you did!). You should see a message like this:

```
Auto-merging Main.java
CONFLICT (content): Merge conflict in Main.java
Automatic merge failed; fix conflicts and then commit the result.
```

#### Resolving Conflicts

1. The person who just attempted to push should open the Checking.java file in VS Code (if not already open). VIEW THIS FILE TOGETHER. You will notice that your conflict is surrounded with text like this:

```
<<<<<<< HEAD                                                                    
      int length = 2;                                                           
=======                                                                         
      int size = 2;                                                             
>>>>>>> 5436b807155c2b2adf171115b1fe74d94eb7f8aa 
```

In this conflict above, one person changed the variable name to _length_ and the other to _size_. The lines between _<<<<<<< HEAD_  and _======_ are the change in your local repo that you made, and the lines between _======_ and _>>>>> 543..._ are the ones pulled from the repo.

2. You will also notice options above related to accepting and viewing the changes. Choose to view the changes, then choose to **Accept Current Changes**. You will notice the extra text goes away.

> NOTE: If you are using an editor that is not integrated with git, you can still resolve this conflict by simply editing the file and removing the lines that were added to highlight the conflict.

3. Again, add, commit, and push.

4. Now the other person needs to pull. NOTICE that there is no merge conflict -- your changes are now gone and only the one from your partner remains.

#### More Conflicts

Repeat the above process in the Savings.java file. This time change roles so that the other person has to fix the merge conflict. Also, this time **Accept Incoming Changes** and see how that changes things.

For the person who did not fix the conflict, do not forget to `git pull` to ensure your repo is up-to-date and matches your partner.

<hr>

#### Configuring .gitignore

When sharing code, you typically only need to share the _source_ files (e.g. files that end in .java or .cpp or .py) -- not the executables (e.g. files that end in .class or .exe). And you should not share anything that can be generated locally from the shared files. For this reason, it does not make sense to push and pull any javadocs. 

1. First, view the .gitignore file (you can open it in VS code). If it was created by BitBucket, it will have a lot of types of files listed. Anything that matches the pattern will not be tracked in the repo. For example, if the .gitignore file had just 

```
*.class
```
any file ending in _.class_ will not be tracked in the repo.

Let's work on some Javadocs to have something to ignore ...

1. At the command prompt, make sure you are in the current repo.
1. `mkdir docs` to create a documentation folder.
1. `cd docs` to move to the folder.
1. `javadoc ../*.docs` to create the html pages.
1. `cd ..` to move back up a level
1. `git add *`
1. `git commit -m "adding docs"`
1. `git push`

BUT WAIT, you just said we do not want the javadocs in the repo!!! Yes, I did. Let's fix that.

#### Remove the Javadocs

1. `rm -r docs`

The -r option is for "recursive", meaning recursively remove all folders and files, no matter how deep into that directory. **Do be careful with this!! Removing at the command line does not put anything in your Trash -- it is not retrievable!!** You can always choose to go back to your Finder or Explorer to move things to the Trash instead.

2. View the directory contents with `ls` to see that it is gone.

3. `git status`

> NOTE: It will tell you there aren't any changes and that you need to stage all the deletes. Once you have added something to your repo, you cannot simply remove it -- it is still there!! You need to use git to remove it.

4. `git rm -r docs`
5. `git commit -m "removing docs"`
6. `git push`

This will now remove it from your repo. 

#### Setup .gitignore

1. Edit your .gitignore file adding this to the bottom:
  ```
  # Documentation
  docs
  ```
1. Repeat the steps above to make the docs directory and generate the documentation.
1. `git add *`

You will get the message that docs is being ignored and if you really want to add it, you can use the `-f` flag to force the commit.

<hr>

#### UNDOING a Local Change

Sometimes you make a change and add it locally, but then you realize you didn't really want to do that. 

1. Both of you create a file _Dummy.java_ and type something in it. Then add it to the repo BUT DO NOT COMMIT.

2. `git status` to see it "staged" for committing. 

3. To remove it from this do 
```
git reset HEAD Dummy.java
git status
```

Now you should see that it is waiting to be staged. 

4. Now remove the file ...
```
rm dummy.java
```

You do not have to use the `git rm` command because it was never entered into your repo!

> NOTE: You can revert back to any of the versions that you committed and pushed to the server. That will be for another day!


#### EXPLORING THE COMMITS

You do not need to submit anything for this exercise because I can view everything. I will be able to see the merge conflicts from each person and how they were merged. I will be able to see the adding, then removing of the documentation.

1. To see the history, go to BitBucket and navigate to the repo. 

2. Click on the "Commits" in the left sidebar and you will see a picture of all the commits. 

3. Explore some of those commits to see the changes. 

- Notice that code will be highlighted in green and red, for adding and removing code, respectively. You can choose to see the differences side-by-side too.

- Notice the -m messages appearing with each commit.
