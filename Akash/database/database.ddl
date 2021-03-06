

-- change this to your team id
use FTP116;


-- comment this line for the very first time
DROP TABLE IF EXISTS LEAVEDETAILS;

-- comment this line for the very first time
drop table if exists EMPLOYEE;

-- create the EMPLOYEDETAILS table
CREATE TABLE EMPLOYEDETAILS
(
	EMP_ID INT,
    EMP_FULL_NAME VARCHAR(30),
    EMP_EMAIL_ID VARCHAR(30),
    EMP_MOBILE_NO VARCHAR (15),
    EMP_DATE_OF_JOINING DATE,
    EMP_DEPARTMENT VARCHAR(30),
    EMP_LEAVE_BALANCE INT,
    EMP_MGR_ID INT,
    CONSTRAINT PK_EMPLOYEDETAILS_EMP_ID PRIMARY KEY(EMP_ID),
	CONSTRAINT FK_EMPLOYEDETAILS_EMP_MGR_ID FOREIGN KEY(EMP_MGR_ID)
	REFERENCES EMPLOYEDETAILS(EMP_ID)
    );

-- create the LEAVEDETAILS table

CREATE TABLE LEAVEDETAILS
    (
		EMP_ID INT,
        LEA_LEAVE_ID INT AUTO_INCREMENT,
        LEA_NUM_OF_DAYS INT,
        LEA_START_DATE DATE,
        LEA_END_DATE DATE,
        LEA_STATUS ENUM('PENDING','APPROVED','DENIED'),
		LEA_LEAVE_TYPE ENUM('ML','PL','EL'),
        LEA_REASON VARCHAR(30),
        LEA_APPLIED_ON DATE,
        LEA_MANAGER_COMMENTS VARCHAR(50),
        CONSTRAINT PK_LEAVEDETAILS_LEA_LEAVE_ID PRIMARY KEY(LEA_LEAVE_ID),
        CONSTRAINT FK_LEAVEDETAILS_EMP_ID FOREIGN KEY(EMP_ID)
        REFERENCES EMPLOYEDETAILS(EMP_ID)
	);