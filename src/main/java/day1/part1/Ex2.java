package day1.part1;

enum ReportingType {
    CSV, XML;
}

class ReportingService {

    public void generateReportBasedOnType(ReportingType reportingType) {
        System.out.println("===================================");
        System.out.println("Generating report based on Type");
        System.out.println("===================================");

        if ("CSV".equalsIgnoreCase(reportingType.toString())) {
            generateCSVReport();
        } else if ("XML".equalsIgnoreCase(reportingType.toString())) {
            generateXMLReport();
        }
    }

    private void generateCSVReport() {
        System.out.println("Generate CSV Report");
    }

    private void generateXMLReport() {
        System.out.println("Generate XML Report");
    }
}

class GenerateReportMain {

    public static void main(String[] args) {
        ReportingService rs = new ReportingService();

        // Generate CSV file
        rs.generateReportBasedOnType(ReportingType.CSV);

        System.out.println();

        // Generate XML file
        rs.generateReportBasedOnType(ReportingType.XML);
    }
}
