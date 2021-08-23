# TimesheetApprovalWorkflow_FinalProject
Employee portal for small travel agency

Create a timesheet application that allows an employer to track the hours worked by their employees.

Users should be able to register for new accounts. After registering for new accounts, they should be able to log the hours that they have worked for each day.

A user should be able to enter multiple pay codes for each day and specify the hours (start and end time) for each pay code.

The following pay codes should be available to the user:

Regular
Leave Without Pay
Annual Leave
Comp Time Earned
Comp Time Used
Holiday
Holiday Worked (1.5x the hourly rate)
Regular Overtime (1.5x the hourly rate)
Holiday Overtime (worked holiday over 8 hours, 2x the hourly rate)
If a user earns comp time, it gets credited to their account but they will not be paid for those hours during the pay period.

A user can only use as many comp time hours for leave as they have available.

Users can save and go back to edit their timesheet at any time before submission. After submission, the timesheet should still be editable as long as their supervisor has not approved their hours yet. Once the supervisor has already approved their timesheet, the employee should not be allowed to make any more edits to their timesheet.

If the supervisor rejects an employee's timesheet, a reason must be provided. An email should get generated and sent to the employee with the reason for rejection. At this point, the timesheet is made editable to the employee again.

Upon submission of their timesheet, an email is sent to the user for confirmation and another email should also be sent to the employee's supervisor to notify them that they have a timesheet in their queue for approval.

After a supervisor approves a timesheet, generate a pay stub with the employee's information and their gross earnings for that pay period.

Supervisors should be able to log into the system a view a list of all their subordinates along with their timesheets. Each timesheet should be marked by the current stage in the workflow it's currently at.

Workflow stages include:

Create timesheet (edit/save timesheet)
Timesheet editing stage
Supervisor approval (if rejected, timesheet goes back to "Timesheet Editing" stage)
If approved, timesheet goes to "Timesheet Approval" stage
Supervisors can generate lists of unapproved timesheets, approved timesheets or rejected timesheets.

Timesheets should display the current stage it's at, date, hours worked by the employee, and pay codes for specific times of each day. There should also be an additional tab in the timesheet displaying the actions taken against the timesheet along with the action name, user who took the action and the date/time of the action.

Timesheets older than two years in the system should be archived.

For each action taken by the user in the system, log the action name, the user who took that action, and the date/time the action was taken.

--------------------------------




#Website link
https://tranquil-savannah-35526.herokuapp.com/
