coursera-getData
================


#The script
The file run_analysis.R is the R script that performs the data procesing.
The resulting data set is writen as a comma separeted .txt called "tidy data.txt".


##How does it work
The script reads files to be merged keeping the order test-train in order to keep de data coherent. This means that every merge keeps the data in the "test" version of the file in the first rows of the data frame and then the ones belonging to the "train" part of the same data.  
Firstly, the x files are merged, labeled and filtered. The filtering of the colums applied refers to colums wich contain either the text "mean" or std" ignoring wheter if its upper or lower case.

Then the y files are merged and its only column labeled as "Activity"
Then the subject data is merged and its only column labeled as "Subject"
The three sets are merged.

Later the data is gouped by "Activity" and then "Subject" and the mean of every other column calculated by this factors.

#Variables

  * Activity = Which activity was being performed by the "Subject". 
(WALKING, WALKING_UPSTAIRS, WALKING_DOWNSTAIRS, SITTING, STANDING or LAYING)
  * Subject = Which anonymus subject was performing the Activity (Subjects range from id 1 to 30)
  The rest of the variables represent the means of the measurements obtained from the embedded accelerometer and gyroscope of a Samsung Galaxy SII grouped by Activity and Subject.

