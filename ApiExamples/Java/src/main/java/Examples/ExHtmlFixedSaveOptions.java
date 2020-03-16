package Examples;

//////////////////////////////////////////////////////////////////////////
// Copyright (c) 2001-2020 Aspose Pty Ltd. All Rights Reserved.
//
// This file is part of Aspose.Words. The source code in this file
// is only intended as a supplement to the documentation, and is provided
// "as is", without warranty of any kind, either expressed or implied.
//////////////////////////////////////////////////////////////////////////

import com.aspose.words.*;
import org.apache.commons.io.FilenameUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;

public class ExHtmlFixedSaveOptions extends ApiExampleBase {
    @Test
    public void useEncoding() throws Exception {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.Encoding
        //ExSummary:Shows how to set encoding while exporting to HTML.
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        builder.writeln("Hello World!");

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setEncoding(Charset.forName("US-ASCII"));

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.UseEncoding.html", htmlFixedSaveOptions);
        //ExEnd
    }

    // Note: Test doesn't contain validation result, because it's may take a lot of time for assert result
    // For validation result, you can save the document to HTML file and check out with notepad++, that file encoding will be correctly displayed (Encoding tab in Notepad++)
    @Test
    public void exportEmbeddedObjects() throws Exception {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedCss
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedFonts
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedImages
        //ExFor:HtmlFixedSaveOptions.ExportEmbeddedSvg
        //ExSummary:Shows how to export embedded objects into HTML file.
        Document doc = DocumentHelper.createDocumentFillWithDummyText();

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setExportEmbeddedCss(true);
        htmlFixedSaveOptions.setExportEmbeddedFonts(true);
        htmlFixedSaveOptions.setExportEmbeddedImages(true);
        htmlFixedSaveOptions.setExportEmbeddedSvg(true);

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.ExportEmbeddedObjects.html", htmlFixedSaveOptions);
        //ExEnd
    }

    @Test
    public void exportFormFields() throws Exception {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.ExportFormFields
        //ExSummary:Show how to exporting form fields from a document into HTML file.
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        builder.insertCheckBox("CheckBox", false, 15);

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setExportFormFields(true);

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.ExportFormFields.html", htmlFixedSaveOptions);
        //ExEnd
    }

    @Test
    public void addCssClassNamesPrefix() throws Exception {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.CssClassNamesPrefix
        //ExFor:HtmlFixedSaveOptions.SaveFontFaceCssSeparately
        //ExSummary:Shows how to add prefix to all class names in css file.
        Document doc = new Document(getMyDir() + "Bookmarks.docx");

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setCssClassNamesPrefix("test");
        htmlFixedSaveOptions.setSaveFontFaceCssSeparately(true);

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.AddCssClassNamesPrefix.html", htmlFixedSaveOptions);
        //ExEnd

        DocumentHelper.findTextInFile(getArtifactsDir() + "HtmlFixedSaveOptions.AddCssClassNamesPrefix/styles.css", "test");
    }

    @Test
    public void horizontalAlignment() throws Exception {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.PageHorizontalAlignment
        //ExFor:HtmlFixedPageHorizontalAlignment
        //ExSummary:Shows how to set the horizontal alignment of pages in HTML file.
        Document doc = new Document(getMyDir() + "Bookmarks.docx");

        HtmlFixedSaveOptions htmlFixedSaveOptions = new HtmlFixedSaveOptions();
        htmlFixedSaveOptions.setPageHorizontalAlignment(HtmlFixedPageHorizontalAlignment.LEFT);

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.HorizontalAlignment.html", htmlFixedSaveOptions);
        //ExEnd
    }

    @Test
    public void pageMargins() throws Exception {
        //ExStart
        //ExFor:HtmlFixedSaveOptions.PageMargins
        //ExSummary:Shows how to set the margins around pages in HTML file.
        Document doc = new Document(getMyDir() + "Bookmarks.docx");

        HtmlFixedSaveOptions saveOptions = new HtmlFixedSaveOptions();
        saveOptions.setPageMargins(10.0);

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.PageMargins.html", saveOptions);
        //ExEnd
    }

    @Test
    public void pageMarginsException() {
        HtmlFixedSaveOptions saveOptions = new HtmlFixedSaveOptions();
        Assert.assertThrows(IllegalArgumentException.class, () -> saveOptions.setPageMargins(-1));
    }

    @Test
    public void optimizeGraphicsOutput() throws Exception {
        //ExStart
        //ExFor:FixedPageSaveOptions.OptimizeOutput
        //ExFor:HtmlFixedSaveOptions.OptimizeOutput
        //ExSummary:Shows how to optimize document objects while saving to html.
        Document doc = new Document(getMyDir() + "Unoptimized content.docx");

        HtmlFixedSaveOptions saveOptions = new HtmlFixedSaveOptions();
        saveOptions.setOptimizeOutput(true);

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.OptimizeGraphicsOutput.html", saveOptions);
        //ExEnd
    }

    //ExStart
    //ExFor:ExportFontFormat
    //ExFor:HtmlFixedSaveOptions.FontFormat
    //ExFor:HtmlFixedSaveOptions.UseTargetMachineFonts
    //ExFor:IResourceSavingCallback
    //ExFor:IResourceSavingCallback.ResourceSaving(ResourceSavingArgs)
    //ExFor:ResourceSavingArgs
    //ExFor:ResourceSavingArgs.Document
    //ExFor:ResourceSavingArgs.KeepResourceStreamOpen
    //ExFor:ResourceSavingArgs.ResourceFileName
    //ExFor:ResourceSavingArgs.ResourceFileUri
    //ExFor:ResourceSavingArgs.ResourceStream
    //ExSummary:Shows how used target machine fonts to display the document.
    @Test //ExSkip
    public void usingMachineFonts() throws Exception {
        Document doc = new Document(getMyDir() + "Bullet points with alternative font.docx");

        HtmlFixedSaveOptions saveOptions = new HtmlFixedSaveOptions();
        saveOptions.setUseTargetMachineFonts(true);
        saveOptions.setFontFormat(ExportFontFormat.TTF);
        saveOptions.setExportEmbeddedFonts(false);
        saveOptions.setResourceSavingCallback(new ResourceSavingCallback());

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.UsingMachineFonts.html", saveOptions);
    }

    private static class ResourceSavingCallback implements IResourceSavingCallback {
        /**
         * Called when Aspose.Words saves an external resource to fixed page HTML or SVG.
         */
        public void resourceSaving(final ResourceSavingArgs args) {
            System.out.println(MessageFormat.format("Original document URI:\t{0}", args.getDocument().getOriginalFileName()));
            System.out.println(MessageFormat.format("Resource being saved:\t{0}", args.getResourceFileName()));
            System.out.println(MessageFormat.format("Full uri after saving:\t{0}", args.getResourceFileUri()));

            args.setResourceStream(new ByteArrayOutputStream());
            args.setKeepResourceStreamOpen(true);

            String extension = FilenameUtils.getExtension(args.getResourceFileName());
            switch (extension) {
                case "ttf":
                case "woff":
                    Assert.fail("'ResourceSavingCallback' is not fired for fonts when 'UseTargetMachineFonts' is true");
                    break;
            }
        }
    }
    //ExEnd

    //ExStart
    //ExFor:HtmlFixedSaveOptions
    //ExFor:HtmlFixedSaveOptions.ResourceSavingCallback
    //ExFor:HtmlFixedSaveOptions.ResourcesFolder
    //ExFor:HtmlFixedSaveOptions.ResourcesFolderAlias
    //ExFor:HtmlFixedSaveOptions.SaveFormat
    //ExFor:HtmlFixedSaveOptions.ShowPageBorder
    //ExSummary:Shows how to print the URIs of linked resources created during conversion of a document to fixed-form .html.
    @Test //ExSkip
    public void htmlFixedResourceFolder() throws Exception {
        // Open a document which contains images
        Document doc = new Document(getMyDir() + "Rendering.docx");

        HtmlFixedSaveOptions options = new HtmlFixedSaveOptions();
        {
            options.setSaveFormat(SaveFormat.HTML_FIXED);
            options.setExportEmbeddedImages(false);
            options.setResourcesFolder(getArtifactsDir() + "HtmlFixedResourceFolder");
            options.setResourcesFolderAlias(getArtifactsDir() + "HtmlFixedResourceFolderAlias");
            options.setShowPageBorder(false);
            options.setResourceSavingCallback(new ResourceUriPrinter());
        }

        // A folder specified by ResourcesFolderAlias will contain the resources instead of ResourcesFolder
        // We must ensure the folder exists before the streams can put their resources into it
        new File(options.getResourcesFolderAlias()).mkdir();

        doc.save(getArtifactsDir() + "HtmlFixedSaveOptions.HtmlFixedResourceFolder.html", options);
    }

    /// <summary>
    /// Counts and prints URIs of resources contained by as they are converted to fixed .Html.
    /// </summary>
    private static class ResourceUriPrinter implements IResourceSavingCallback {
        public void resourceSaving(ResourceSavingArgs args) throws Exception {
            // If we set a folder alias in the SaveOptions object, it will be printed here
            System.out.println(MessageFormat.format("Resource #{0} \"{1}\"", ++mSavedResourceCount, args.getResourceFileName()));

            String extension = FilenameUtils.getExtension(args.getResourceFileName());
            switch (extension) {
                case "ttf":
                case "woff": {
                    // By default 'ResourceFileUri' used system folder for fonts
                    // To avoid problems across platforms you must explicitly specify the path for the fonts
                    args.setResourceFileUri(getArtifactsDir() + File.separatorChar + args.getResourceFileName());
                    break;
                }
            }
            System.out.println("\t" + args.getResourceFileUri());

            // If we specified a ResourcesFolderAlias we will also need to redirect each stream to put its resource in that folder
            args.setResourceStream(new FileOutputStream(args.getResourceFileUri()));
            args.setKeepResourceStreamOpen(false);
        }

        private int mSavedResourceCount;
    }
    //ExEnd
}