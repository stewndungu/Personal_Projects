# Table of Contents
- [Expiration Inventory](#expiration-inventory)
- [Extra Needed Applications](#extra-needed-applications)
- [Prerequisites Knowledge](#prerequisites-knowledge)
- [Prerequisites Steps](#prerequisites-steps)


# Expiration Inventory

The premise was to help the small convenience store that I work for to track the dates for their items. So employees can remove them before their expiration date

## Extra Needed Applications
 - [PHP Admin](https://www.phpmyadmin.net/downloads/) - To store the items in distinct categorized databases
 - [Google App Script](https://developers.google.com/apps-script) - Connects to your databases through the BAT Files and send an email to whomever is the supervisor/manager of the recent list


### Prerequisites Knowledge
_Have a good understanding of these topics & subtopics in case you want to edit & modify (beginner knowledge should suffice)_

- Windows file paths
- SQL 
- PHP
- BAT
- HTML & CSS
- Understanding of Google drive
- -Javascript
### Prerequisites Steps
_A guide on how to install the tools needed for running the project._

- PHP Admin : Follow this [video](https://www.youtube.com/watch?v=cKr237iUlwo) along with the writing
```bash
- Click the link provided above for PHP admin and download the recent version
   --- If you follow the video exactly (link in the word video), you should still be all right
- After completing the download, you can follow the video until get to the select components for the xampp.

   --- you really only need apache & mysql. Unless the checkbox is greyed out, you do not have to check on the rest of them.

- Continue to click next until it starts to download the compenents
   --- If you use another language or want it in another file location, you can modify to your liking, but remember where it is because you will need to modify other areas too!

- Search your computer for an application called Xampp Control Panel
   --- Make sure to start and start under apache and mysql actions
   --- For mysql, there is a default port used in. If you are using that default port for something else, the video has links to common problems and fixes.
      --- You can also search up solutions as well, they tend to involve the config.ini file that holds info like password for DB & port number
    
```
 - [Google App Script](https://developers.google.com/apps-script/) : click start scripting
```bash
- Click the link provided at the top and sign in to your google account

- You can copy the code for the script in Google App Script (Called: GoogleAPPScript)
    --- Go to editor > create your own gs file. I just typed code.gs >paste the code
- Notice the "var folder id". That variable comes from the url of from your google drive
```
- [Google Drive for Desktop](https://support.google.com/drive/answer/10838124?hl=en) : scroll down to find the instructions for download
```
 - Got to the google drive for desktop link
 - Make sure the same account you signed up for google app script is the same for the google drive for desktop
 - Make a folder the files
 - Once you made the folder, click to go into it, then check at the url bar and see the long alphanumeric writing after the "/"
   - Thats the folder ID
```
