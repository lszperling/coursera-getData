library(dplyr)
#Merging x
x_test <- read.table("test//X_test.txt")
x_train <- read.table("train//X_train.txt")
x_merge <- rbind(x_test,x_train)

#Labeling and subseting x
features <- read.table("features.txt")
colnames(x_merge) <- features$V2
filtered <- x_merge[ , grepl( "(mean)|(std)" , names( x_merge ), ignore.case = TRUE ) ]
complete <- cbind(filtered,y_merge)

#Merging y
y_test <- read.table("test//Y_test.txt")
y_train <- read.table("train//Y_train.txt")
y_merge <- rbind(y_test,y_train)
colnames(y_merge) <- "Activity"

#Merging subjects
subject_test <- read.table("test//subject_test.txt")
subject_train <- read.table("train//subject_train.txt")
subject_merge <- rbind(subject_test, subject_train)
colnames(subject_merge) <- "Subject"

#Merging the 3 merged data sets (x,y,subjects)
activities <- read.table("activity_labels.txt")
appropiate <- within(complete, Activity <- factor(Activity, labels = activities$V2))
full <- cbind(appropiate,subject_merge)

to_filter <- tbl_df(full)
grouped  <- group_by(full, Activity, Subject)
summarised <- summarise_each(grouped, funs(mean))
write.table(summarised, "tidy data.txt", row.names = FALSE)
