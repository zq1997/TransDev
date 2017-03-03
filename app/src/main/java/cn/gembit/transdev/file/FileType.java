package cn.gembit.transdev.file;

import android.webkit.MimeTypeMap;

import cn.gembit.transdev.R;

public class FileType {

    public final static int DIR = 0;
    public final static int FILE_APK = 1;
    public final static int FILE_ARCHIVE = 2;
    public final static int FILE_AUDIO = 3;
    public final static int FILE_EXCEL = 4;
    public final static int FILE_IMAGE = 5;
    public final static int FILE_PDF = 6;
    public final static int FILE_PPT = 7;
    public final static int FILE_TEXT = 8;
    public final static int FILE_VIDEO = 9;
    public final static int FILE_WORD = 10;
    public final static int FILE_UNKNOWN = -1;

    public static String getNameExtension(String name) {
        if (name != null) {
            int index = name.lastIndexOf('.');
            if (index > 0 && index < name.length() - 1) {
                return name.substring(index + 1).toLowerCase();
            }
        }
        return "";
    }

    public static int judgeTypeByName(String name) {
        String extension = FileType.getNameExtension(name);
        switch (extension) {
            case "":
                return FILE_UNKNOWN;

            case "apk":
                return FILE_APK;

            case "doc":
            case "docx":
                return FILE_WORD;

            case "xls":
            case "xlsx":
                return FILE_EXCEL;

            case "ppt":
            case "pptx":
                return FILE_PPT;

            case "pdf":
                return FILE_PDF;

            case "zip":
            case "rar":
            case "7z":
            case "tar":
            case "gz":
            case "bz2":
            case "tgz":
                return FILE_ARCHIVE;

            default:
                break;
        }

        String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        if (mime != null) {
            if (mime.startsWith("text/")) {
                return FILE_TEXT;
            }

            if (mime.startsWith("audio/")) {
                return FILE_AUDIO;
            }

            if (mime.startsWith("image/")) {
                return FILE_IMAGE;
            }

            if (mime.startsWith("video/")) {
                return FILE_VIDEO;
            }
        }
        return FILE_UNKNOWN;
    }

    public static int getIcon(int fileType) {
        switch (fileType) {
            case DIR:
                return R.drawable.ic_dir;

            case FILE_APK:
                return R.drawable.ic_file_apk;

            case FILE_ARCHIVE:
                return R.drawable.ic_file_archive;

            case FILE_AUDIO:
            return R.drawable.ic_file_audio;

            case FILE_EXCEL:
            return R.drawable.ic_file_excel;

            case FILE_IMAGE:
            return R.drawable.ic_file_image;

            case FILE_PDF:
            return R.drawable.ic_file_pdf;

            case FILE_PPT:
            return R.drawable.ic_file_ppt;

            case FILE_TEXT:
            return R.drawable.ic_file_text;

            case FILE_UNKNOWN:
            return R.drawable.ic_file_unknown;

            case FILE_VIDEO:
            return R.drawable.ic_file_video;

            case FILE_WORD:
            return R.drawable.ic_file_word;

            default:
                return R.drawable.ic_file_unknown;
        }
    }
}
