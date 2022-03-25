# rev-proj1
# Reimbursement project

## Project Description

This is a reimbursement project with a separate user and admin login. Anyone can create a user account which gets added to the database with a unique username ID, and then can login. They can submit a reimbursement request to the manager and the date/time stamp, user information, and amount will be stored in a database. They can also enter their personal details upon sign in and update them at any point. The project has cookie tracking to keep track of who is in the sesion to make sure one cannot see the same page after already being logged in or out.
The manager has a separate login, and can view a scrollable table of all requests made. It includes the username, employee name, exact date/time, and amount. They can easily select the ones they want to approve or deny and it will reload the page and update the database. They can also view requests by a specific user (username). Additionally, they can view all employee personal details like name, email, etc.

## Technologies Used

* Java version 11
* Servlets
* Html/CSS version 5
* Javascript 
* Maven
* Hibernate version 6
* TomCat version 10

## Features

List of features ready and TODOs for future development
* Manager can automatically approve or deny requests by checking boxes
* Exact date and timestamp of request is viewable and recorded
* Hibernate efficiently returns and stores queries in database
* Website details are customized for user

To-do list:
* Make it so that once a request is approved or denied, there is no more changing it
* Move navbar to the top or side of page
* Have employee information visible when updating it

## Getting Started
   
(include git clone command)
(include all environment setup steps)

> Be sure to include BOTH Windows and Unix command  
> Be sure to mention if the commands only work on a specific platform (eg. AWS, GCP)

* Run this project on intellij
* Configure the pom.xml file and webapp and make sure the name of the database is the same as the one you are using
* Lastly, some of the images in the folder were ignored, so feel free to update the project with custom images when using them in the html page

## Usage

* To demonstrate a sample reimbursement transaction and deal with multiple users in a database


## License

This project uses the following license: [MIT license](LICENSE).
