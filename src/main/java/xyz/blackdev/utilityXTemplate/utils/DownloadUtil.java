package xyz.blackdev.utilityXTemplate.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.net.URL;

public class DownloadUtil {
    public static void downloadFile(String fileURL, String targetDir) throws Exception {
        URL url = new URL(fileURL);
        String fileName = Path.of(url.getPath()).getFileName().toString();
        Path targetPath = Path.of(targetDir, fileName);

        try (InputStream in = url.openStream()) {
            Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}