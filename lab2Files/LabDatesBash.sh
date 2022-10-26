#! /bin/bash

#menu options
echo ------ Days Lab -------     
echo *Key words for dates:
echo lab1, lab2, lab3, lab4, quiz1, quiz2
echo quiz3, quiz4, quiz5, finalexam, todaysDate

#declared dates
lab1=$(date -d 2022-09-28 +%Y%m%d)
lab2=$(date -d 2022-10-26 +%Y%m%d)
lab3=$(date -d 2022-11-23 +%Y%m%d)
lab4=$(date -d 2022-12-07 +%Y%m%d)
quiz1=$(date -d 2022-09-14 +%Y%m%d)
quiz2=$(date -d 2022-09-28 +%Y%m%d)
quiz3=$(date -d 2022-10-26 +%Y%m%d)
quiz4=$(date -d 2022-11-16 +%Y%m%d)
quiz5=$(date -d 2022-12-07 +%Y%m%d)
finalExam=$(date -d 2022-12-19 +%Y%m%d)
todaysDate=$(date +%Y%m%d)

#reads input
read -p "Enter first date " firstDate
read -p "Enter second date " secondDate

#checks for keywords
case $firstDate in
    
    "lab1")
    ((++checkfirstKey))
    firstDate=$lab1
    ;;
    
    "lab2")
    ((++checkfirstKey))
    firstDate=$lab2
    ;;
    
    "lab3")
    ((++checkfirstKey))
    firstDate=$lab3
    ;;
    
    "lab4")
    ((++checkfirstKey))
    firstDate=$lab4
    ;;
    
    "quiz1")
    ((++checkfirstKey))
    firstDate=$quiz1
    ;;
    
    "quiz2")
    ((++checkfirstKey))
    firstDate=$quiz2
    ;;
    
    "quiz3")
    ((++checkfirstKey))
    firstDate=$quiz3
    ;;
    
    "quiz4")
    ((++checkfirstKey))
    firstDate=$quiz4
    ;;
    
    "quiz5")
    ((++checkfirstKey))
    firstDate=$quiz5
    ;;
    
    "finalexam")
    ((++checkfirstKey))
    firstDate=$finalExam
    ;;
    
    "todaysDate")
    ((++checkfirstKey))
    firstDate=$todaysDate
    ;;
*)
    echo "Not a valid key for first input."
    ;;
esac

#checks for keywords 
case $secondDate in
    
    "lab1")
    ((++checksecondKey))
    secondDate=$lab1
    ;;
    
    "lab2")
    ((++checksecondKey))
    secondDate=$lab2
    ;;
    
    "lab3")
    ((++checksecondKey))
    secondDate=$lab3
    ;;
    
    "lab4")
    ((++checksecondKey))
    secondDate=$lab4
    ;;
    
    "quiz1")
    ((++checksecondKey))
    secondDate=$quiz1
    ;;
    
    "quiz2")
    ((++checksecondKey))
    secondDate=$quiz2
    ;;
    
    "quiz3")
    ((++checksecondKey))
    secondDate=$quiz3
    ;;
    
    "quiz4")
    ((++checksecondKey))
    secondDate=$quiz4
    ;;
    
    "quiz5")
    ((++checksecondKey))
    secondDate=$quiz5
    ;;
    
    "finalexam")
    ((++checksecondKey))
    secondDate=$finalExam
    ;;
    
    "todaysDate")
    ((++checksecondKey))
    secondDate=$todaysDate
    ;;
*)
    echo "Not a valid key for second input."
    ;;
esac 

#if valid, then it'll print the days in between the two dates
if [ $checkfirstKey -eq 1 ] && [ $checksecondKey -eq 1 ]
then 
    let DIFF=($(date +%s -d $firstDate)-$(date +%s -d $secondDate))/86400
    echo "${DIFF#-} day(s) in between the two dates"
else 
    echo "try again using the correct keys."
fi

#sample output:
#------ Days Lab -------
#*Key words for dates:
#lab1, lab2, lab3, lab4, quiz1, quiz2
#quiz3, quiz4, quiz5, finalexam, todaysDate
#Enter first date todaysDate
#Enter second date lab2
#1 day(s) in between the two days