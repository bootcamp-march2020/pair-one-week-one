package part1.solution;

interface IReportingService{
    void generateReport();
}

class CSVReportService implements IReportingService{
    @Override
    public void generateReport() {
        System.out.println("Generate CSV Report");
    }
}


class XMLReportService implements IReportingService{
    @Override
    public void generateReport() {
        System.out.println("Generate XML Report");
    }
}


class ReportingService {

    private void generateReport(IReportingService service){
        service.generateReport();
    }

    public void generateCSVReport() {
        generateReport(new CSVReportService());
    }

    public void generateXMLReport() {
        generateReport(new XMLReportService());
    }
}

class GenerateReportMain {

    public static void main(String[] args) {

        ReportingService rs = new ReportingService();

        // Generate CSV file
        rs.generateCSVReport();

        System.out.println();

        // Generate XML file
        rs.generateXMLReport();
    }
}
