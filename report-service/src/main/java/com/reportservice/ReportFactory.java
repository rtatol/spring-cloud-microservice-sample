package com.reportservice;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

@AllArgsConstructor(staticName = "from")
class ReportFactory {

    private final AccountsResource accountsResource;

    byte[] create() throws IOException {

        final ByteArrayOutputStream documentByteArrayOutput = new ByteArrayOutputStream();

        try (final PDDocument document = new PDDocument()) {
            final PDPage page = new PDPage();
            document.addPage(page);
            try (final PDPageContentStream contents = new PDPageContentStream(document, page)) {
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(100, 700);
                contents.showText(createReportText());
                contents.endText();
            }
            document.save(documentByteArrayOutput);
        }

        return documentByteArrayOutput.toByteArray();
    }

    private String createReportText() {
        return accountsResource.getEmbedded()
                .getAccounts().stream()
                .map(account -> account.getFirstName() + " " + account.getLastName())
                .collect(Collectors.joining(" | "));
    }
}
