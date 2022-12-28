# Hall_Admission_System

Hall Admission System is designed as a solution to handle the hall admission procedure for both the student and the university. It is an admission platform that accepts student applications to halls and automatically admits applications based on predefined rules and hall requirements. This system allows students to browse available halls and submit admission to their desired hall. Students can also check the status of their application to see if it is successful. The staff can update the information on existing halls and add new halls when needed. The staff can also view all applications in the hall and process all the applications automatically with the built-in application processing algorithm.


## User Diagram 

<img src="https://github.com/Kadyu/Hall_Admission_System/blob/main/readMe-img/readMe-image1.png" width="600">

**User Requirement**			</br>		
Users must log in using their username and password through a dedicated login portal to access the Hall Admission System. All accounts are stored in a CSV file named "accounts.csv," When the login portal is initialized, the system reads from this file. Users will get a welcome message and a list of functionalities after successful login.


## Class Diagram

<img src="https://github.com/Kadyu/Hall_Admission_System/blob/main/readMe-img/readMe-image2.png" width="600">

**Design Principles and Patterns**	</br>		
-Open-Closed Principle </br>		
-Interface-Segregation Principle </br>		
-Law of Demeter </br>		
-State Pattern </br>
-Singleton Pattern </br>

## Testing 

<img src="https://github.com/Kadyu/Hall_Admission_System/blob/main/readMe-img/readMe-image3.png" width="700">

**Methodology and Coverage** <br/>

A bottom-up testing approach has been chosen by our team to test and verify the functionalities of the system. The reason behind explicitly choosing this approach is its simplicity and clarity in tracking the testing progress, and test stubs being unessential. Moreover, we believe that since, for the majority of the systems, crucial functionalities are normally stored and performed by the lowermost modules, it is also essential for us to test those first in order to avoid problems in the later stage of the testing phase which perfectly fits with the Bottom-up testing approach. Speaking of which, using this methodology, we can easily track and fix errors and bugs way earlier, since major functionalities getting tested first which makes the testing phase go smoother and avoid complications in the process when testing will start involving more complex structure and classes. Therefore, we have concluded that the Bottom-up approach better aligns with our requirements and purposes than other testing methods.

 <br/>

In order to make the programme reliable, an extensive testing strategy was devised in which, in addition to covering each branch and statement, each decision and the conditions leading to those decisions were aimed to be tested. Moreover, each loop was tested for i == 0, i == 1 and i > 1 times wherever possible. Consequently, Condition Coverage/ Decision Coverage (CC/DC) and Loop Coverage was achieved. 
In terms of coverage percentage, as shown in the figure above, 97.6% of the programme classes were covered. However, if we include the exception classes and test cases as well (fundamentally, every line of code that we have written), the number goes up to 99.1%.
The reason for not being able to achieve 100% testing coverage is that to activate some areas of code, especially areas related to exception handling, faults would have to be introduced in some other areas. Submission of faulty code would be unacceptable, so the testing of such areas was not highlighted in these numbers. Rest assured; these areas were tested in the development process of the code. We could have used testing stubs to overcome this issue, but such a course of action would have damaged the integrity of the Bottom-Up approach as one of the reasons behind adopting this approach was to make the testing process simpler by eliminating the usage of testing stubs.

## Short demo

-Checking application status after creating it <br/>
<br/>
<img src="https://github.com/Kadyu/Hall_Admission_System/blob/main/readMe-img/readMe-image4.png" width="600">



