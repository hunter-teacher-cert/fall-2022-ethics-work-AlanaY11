# AWK Algorithm
### How we instituted our redlining algorithm in our Java Bank Program using data maniupulation in AWK.

To run these commands on a Mac or Linux/UNIX system follow these istructions:

1. Make a folder in your root called 'awk' and place the file '[zipData.csv](./)' inside of it.
1. Open up Terminal program. At the % or $ prompt type...

        cd ~
        cd awk
If you can't run the commands yourself, output links will be provided here in this document.

Print the raw contents of the data file

    awk '{print $0}' zipData.csv
[see output](output_files/output01.md)

Determine the number of fields per record line

    awk 'BEGIN {FS = ","} NR == 1 {print NF}' zipData.csv
 [see output](output_files/output02.md)
    
Create a field number legend so you no what number corresponds to what field. We accomplish this with a 'for' loop through the header line and then print the header field with an '=' and the current 'for' loop count

    awk 'BEGIN {FS = ","} NR == 1 {for (i = 1;i < NF + 1;i++){ print $i, " = ", i, "\n"}}' zipData.csv 
[see output](output_files/output03.md)

Now I save the legend as a separate file for later recall using '>'

    awk 'BEGIN {FS = ","} NR == 1 {for (i = 1;i < NF + 1;i++){ print $i " = " i "\n" > "zipDataTable.txt"}}' zipData.csv

Run cat command to see our table

    cat zipDataTable.txt
[see txt file](./zipDataTable.txt)
    
Now we want to find all zips($4) that have an unbanked 2013 rate($7) of over 10% and print the neighborhood name as a neat table using printf. That will be our criteria for charging a fee in our bank program.

    awk 'BEGIN {FS = ","} $7 > 0.1 {printf("%-40s%6d %4f\n",$1, $4, $7)}' zipData.csv
[see output](output_files/output04.md)

Then create a list of unbanked zips, removing the first 7 records (those are the header, NYC total, and 5 borough's totals NR > 7)

    awk 'BEGIN {FS = ","} $7 > 0.1 && NR > 7 {print $4 > "feeZips.txt"}' zipData.csv
 [see txt file](./feeZips.txt)
 
Last, check our file and pipe it through sort to quickly see if my neighborhood (11222) was excluded

    cat feeZips.txt |sort
 [see output](output_files/output05.md)

Now feeZips.txt will be used in our Java Bank program to digitally redline customers by charging them a fee for their account.
