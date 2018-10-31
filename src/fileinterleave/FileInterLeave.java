
package fileinterleave;
import dao.LineSequential;

public class FileInterLeave {

    
    public static void main(String[] args) 
    {
        //Takes in files
        String inFile = "e:/CIS2206/PayrollMasterA.dat";
        String inFileStreamName1 = "payrollMasterA";
        String ioMode1 = "input";
        String inFile2 = "e:/CIS2206/PayrollMasterB.dat";
        String inFileStreamName2 = "payrollMasterB";
        String ioMode2 = "input";
        String outFile = "e:/CIS2206/PayrollMaster.dat";
        String outFileStreamName = "payrollMaster";
        String ioMode3 = "output";
        String inputLine;

        //Make three files and open
        LineSequential.open(inFile, inFileStreamName1, ioMode1);
        LineSequential.open(inFile2, inFileStreamName2, ioMode2);
        LineSequential.open(outFile, outFileStreamName, ioMode3);
        
        //loop
        //loop will read first line in the text file.
        while((inputLine = LineSequential.read(inFileStreamName1)) != null) 
            //when the first line of string is not equal to null.
        {
            LineSequential.write(outFileStreamName, inputLine);
            //writes to PayrollMaster from File A
            inputLine = LineSequential.read(inFileStreamName2);
            //Takes a line from File B
            LineSequential.write(outFileStreamName, inputLine);
            //write to PayRollMaster from File B
        
        }
        //this loop will consistently take alternating lines
        
        
        //closes line
        LineSequential.close(inFileStreamName1, ioMode1);
        LineSequential.close(inFileStreamName2, ioMode2);
        LineSequential.close(outFileStreamName, ioMode3);
        
        //outputs when process is complete
        System.out.println("File Complete");
    }
    
}
