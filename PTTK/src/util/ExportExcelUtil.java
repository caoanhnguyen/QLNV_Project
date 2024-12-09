package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportExcelUtil {

    // Hàm xuất dữ liệu từ JTable sang Excel
    public static void exportToExcel(JTable table, String fileName) {
        // Mở hộp thoại chọn vị trí và tên file với JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a location to save the Excel file");
        fileChooser.setSelectedFile(new File(fileName+".xlsx")); // Đặt tên file mặc định

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn file mà người dùng chọn
            File file = fileChooser.getSelectedFile();

            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Sheet 1");

                // Lấy dữ liệu từ JTable
                TableModel model = table.getModel();

                // Tạo dòng header trong Excel
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < model.getColumnCount(); i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(model.getColumnName(i)); // Đặt tên cột vào Excel
                }

                // Tạo các dòng dữ liệu trong Excel
                for (int i = 0; i < model.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1); // Dòng dữ liệu bắt đầu từ dòng 1
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);

                        // Kiểm tra giá trị null trước khi ghi vào Excel
                        Object value = model.getValueAt(i, j);
                        if (value != null) {
                            cell.setCellValue(value.toString()); // Chuyển dữ liệu thành chuỗi
                        } else {
                            cell.setCellValue(""); // Nếu giá trị null, ghi giá trị trống
                        }
                    }
                }

                // Lưu file Excel
                try (FileOutputStream fileOut = new FileOutputStream(file)) {
                    workbook.write(fileOut); // Ghi workbook vào file
                    JOptionPane.showMessageDialog(null, "Export to Excel successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (IOException e) {
                // Hiển thị thông báo lỗi nếu không thể lưu file
                JOptionPane.showMessageDialog(null, "Error while exporting: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
