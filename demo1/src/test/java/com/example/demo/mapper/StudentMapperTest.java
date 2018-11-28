package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: cjq
 * @Date: 2018/7/18 20:10
 * @Description:
 * @version:V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
   /* @Autowired
    protected StudentMapper studentMapper;
    @Test
    public void findOne() throws Exception {
        List<Student> all = studentMapper.findAll();
        for (Student Student:all) System.out.println(Student.getName());
    
    }*/

    @Test
    public void testPDF() throws Exception {
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        //页面大小
        Rectangle rect = new Rectangle(PageSize.A4.rotate());
        //Step 1—Create a Document.
        Document document = new Document(rect, 10, 10, 10, 10);
        //Step 2—Get a PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream("createSamplePDF.pdf"));
        //Step 3—Open the Document.
        document.open();
        //Step 4—Add content.
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

        Font fontTitle = new Font(bfChinese, 13, Font.BOLD, BaseColor.BLACK);
        Font fontContent = new Font(bfChinese, 9, Font.NORMAL, BaseColor.BLACK);

        Paragraph title = new Paragraph("中山大学南方学院学生学业成绩表", fontTitle);
        title.setAlignment(1);//居中
        document.add(title);
        //加入空行
        Paragraph blankRow41 = new Paragraph(18f, " ", fontContent);
        document.add(blankRow41);
        //学生信息
        PdfPTable headerTable = new PdfPTable(7);
        headerTable.setWidthPercentage(100);
        int headerwidths[] = {5, 25, 5, 25, 5, 25, 10};
        headerTable.setWidths(headerwidths);
        Phrase xy = new Phrase("学院：", fontContent);
        PdfPCell xyCell = new PdfPCell(xy);
        xyCell.setBorder(0);
        xyCell.setFixedHeight(18);
        headerTable.addCell(xyCell);
        Phrase xymc = new Phrase("文学与传媒系", fontContent);
        PdfPCell xymcCell = new PdfPCell(xymc);
        xymcCell.setBorder(0);
        xymcCell.setFixedHeight(18);
        headerTable.addCell(xymcCell);
        Phrase zy = new Phrase("专业：", fontContent);
        PdfPCell zyCell = new PdfPCell(zy);
        zyCell.setBorder(0);
        zyCell.setFixedHeight(18);
        headerTable.addCell(zyCell);
        Phrase zymc = new Phrase("汉语言文学", fontContent);
        PdfPCell zymcCell = new PdfPCell(zymc);
        zymcCell.setBorder(0);
        zymcCell.setFixedHeight(18);
        headerTable.addCell(zymcCell);
        Phrase bj = new Phrase("班级：", fontContent);
        PdfPCell bjCell = new PdfPCell(bj);
        bjCell.setBorder(0);
        bjCell.setFixedHeight(18);
        headerTable.addCell(bjCell);
        Phrase bjmc = new Phrase("14政商研究1班", fontContent);
        PdfPCell bjmcCell = new PdfPCell(bjmc);
        bjmcCell.setBorder(0);
        bjmcCell.setFixedHeight(18);
        headerTable.addCell(bjmcCell);
        PdfPCell kbCell = new PdfPCell(new Phrase("", fontContent));
        kbCell.setBorder(0);
        kbCell.setFixedHeight(18);
        headerTable.addCell(kbCell);
        document.add(headerTable);

        PdfPTable header2Table = new PdfPTable(10);
        header2Table.setWidthPercentage(100);
        int header2widths[] = {5, 15, 5, 15, 5, 15, 5, 15, 5, 15};
        header2Table.setWidths(header2widths);
        Phrase xh = new Phrase("学号：", fontContent);
        PdfPCell xhCell = new PdfPCell(xh);
        xhCell.setBorder(0);
        xhCell.setFixedHeight(18);
        header2Table.addCell(xhCell);
        Phrase xhmc = new Phrase("17744589", fontContent);
        PdfPCell xhmcCell = new PdfPCell(xhmc);
        xhmcCell.setBorder(0);
        xhmcCell.setFixedHeight(18);
        header2Table.addCell(xhmcCell);
        Phrase xm = new Phrase("姓名：", fontContent);
        PdfPCell xmCell = new PdfPCell(xm);
        xmCell.setBorder(0);
        xmCell.setFixedHeight(18);
        header2Table.addCell(xmCell);
        Phrase xmmc = new Phrase("陈汝你", fontContent);
        PdfPCell xmmcCell = new PdfPCell(xmmc);
        xmmcCell.setBorder(0);
        xmmcCell.setFixedHeight(18);
        header2Table.addCell(xmmcCell);
        Phrase xw = new Phrase("学位：", fontContent);
        PdfPCell xwCell = new PdfPCell(xw);
        xwCell.setBorder(0);
        xwCell.setFixedHeight(18);
        header2Table.addCell(xwCell);
        Phrase xwmc = new Phrase("", fontContent);
        PdfPCell xwmcCell = new PdfPCell(xwmc);
        xwmcCell.setBorder(0);
        xwmcCell.setFixedHeight(18);
        header2Table.addCell(xwmcCell);
        PdfPCell byzshCell = new PdfPCell(new Phrase("毕业证书号：", fontContent));
        byzshCell.setBorder(0);
        byzshCell.setFixedHeight(18);
        header2Table.addCell(byzshCell);
        PdfPCell byzshmcCell = new PdfPCell(new Phrase(" ", fontContent));
        byzshmcCell.setBorder(0);
        byzshmcCell.setFixedHeight(18);
        header2Table.addCell(byzshmcCell);
        PdfPCell byjlCell = new PdfPCell(new Phrase("毕业结论：", fontContent));
        byjlCell.setBorder(0);
        byjlCell.setFixedHeight(18);
        header2Table.addCell(byjlCell);
        PdfPCell byjlmcCell = new PdfPCell(new Phrase(" ", fontContent));
        byjlmcCell.setBorder(0);
        byjlmcCell.setFixedHeight(18);
        header2Table.addCell(byjlmcCell);
        document.add(header2Table);

        //表格
        PdfPTable table0 = new PdfPTable(3);
        table0.setWidthPercentage(100);
        for (int j = 0; j < 3; j++) {
            PdfPTable table = new PdfPTable(5);
            table.setPaddingTop(20);
            int tablewidths[] = {60, 16, 8, 8, 8}; // percentage
            table.setWidths(tablewidths);
            table.setWidthPercentage(33);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            //表头
            Phrase kcmc = new Phrase("课程名称", fontContent);
            PdfPCell kcmcCell = new PdfPCell(kcmc);
            kcmcCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Phrase xz = new Phrase("性质", fontContent);
            PdfPCell kcxzCell = new PdfPCell(xz);
            kcxzCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Phrase xf = new Phrase("学分", fontContent);
            PdfPCell xfCell = new PdfPCell(xf);
            xfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Phrase cj = new Phrase("成绩", fontContent);
            PdfPCell cjCell = new PdfPCell(cj);
            cjCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Phrase jd = new Phrase("绩点", fontContent);
            PdfPCell jdCell = new PdfPCell(jd);
            jdCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(kcmcCell);
            table.addCell(kcxzCell);
            table.addCell(xfCell);
            table.addCell(cjCell);
            table.addCell(jdCell);

            PdfPCell cell;
            Phrase xnxq = new Phrase("2016-2017学年 第1学期", fontContent);
            cell = new PdfPCell(xnxq);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(5);
            table.addCell(cell);
            for (int i = 0; i < 15; i++) {
                table.addCell(new Phrase("数据库原理与应用数据库原理与应用", fontContent));
                table.addCell(new Phrase("必修", fontContent));
                table.addCell(new Phrase("2.0", fontContent));
                table.addCell(new Phrase("89", fontContent));
                table.addCell(new Phrase("3.0", fontContent));
            }
            Phrase xnxq1 = new Phrase("2017-2018学年 第1学期", fontContent);
            cell = new PdfPCell(xnxq1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(5);
            table.addCell(cell);
            for (int i = 0; i < 15; i++) {
                table.addCell(new Phrase("数据库原理与应用", fontContent));
                table.addCell(new Phrase("必修", fontContent));
                table.addCell(new Phrase("2.0", fontContent));
                table.addCell(new Phrase("89", fontContent));
                table.addCell(new Phrase("3.0", fontContent));
            }
            PdfPCell cell0 = new PdfPCell(table);
            cell0.setBorder(0);
            table0.addCell(cell0);
        }
        document.add(table0);
        //学分
        PdfPTable tableXf = new PdfPTable(12);
        tableXf.setWidthPercentage(100);
        int tablewidthXf[] = {10, 10, 10, 10, 4, 8, 8, 8, 8, 8, 8, 8}; // percentage
        tableXf.setWidths(tablewidthXf);
        Phrase lnpjcj = new Phrase("历年平均成绩", fontContent);
        PdfPCell lnpjcjCell = new PdfPCell(lnpjcj);
        lnpjcjCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase lnpjxfjd = new Phrase("历年平均学分绩点", fontContent);
        PdfPCell lnpjxfjdCell = new PdfPCell(lnpjxfjd);
        lnpjxfjdCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase byyqdzxf = new Phrase("毕业应取得总学分", fontContent);
        PdfPCell byyqdzxfCell = new PdfPCell(byyqdzxf);
        byyqdzxfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase yhdzxf = new Phrase("已获得总学分", fontContent);
        PdfPCell yhdzxfCell = new PdfPCell(yhdzxf);
        yhdzxfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase qzbk = new Phrase("其中包括", fontContent);
        PdfPCell qzbkCell = new PdfPCell(qzbk);
        qzbkCell.setRowspan(2);
        qzbkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase ggbxk = new Phrase("公共必修课", fontContent);
        PdfPCell ggbxkCell = new PdfPCell(ggbxk);
        ggbxkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase ggxxk = new Phrase("公共选修课", fontContent);
        PdfPCell ggxxkCell = new PdfPCell(ggxxk);
        ggbxkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase zybxk = new Phrase("专业必修课", fontContent);
        PdfPCell zybxkCell = new PdfPCell(zybxk);
        zybxkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase zyxxk = new Phrase("专业选修课", fontContent);
        PdfPCell zyxxkCell = new PdfPCell(zyxxk);
        zyxxkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase czbxk = new Phrase("成长必修课", fontContent);
        PdfPCell czbxkCell = new PdfPCell(czbxk);
        czbxkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase zsbxk = new Phrase("政商必修课", fontContent);
        PdfPCell zsbxkCell = new PdfPCell(zsbxk);
        zsbxkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Phrase zsxxk = new Phrase("政商选修课", fontContent);
        PdfPCell zsxxkCell = new PdfPCell(zsxxk);
        zsxxkCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(lnpjcjCell);
        tableXf.addCell(lnpjxfjdCell);
        tableXf.addCell(byyqdzxfCell);
        tableXf.addCell(yhdzxfCell);
        tableXf.addCell(qzbkCell);
        tableXf.addCell(ggbxkCell);
        tableXf.addCell(ggxxkCell);
        tableXf.addCell(zybxkCell);
        tableXf.addCell(zyxxkCell);
        tableXf.addCell(czbxkCell);
        tableXf.addCell(zsbxkCell);
        tableXf.addCell(zsxxkCell);
        PdfPCell cell1 = new PdfPCell(new Phrase("78.00", fontContent));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell1);
        PdfPCell cell2 = new PdfPCell(new Phrase("3.57", fontContent));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell2);
        PdfPCell cell3 = new PdfPCell(new Phrase(" ", fontContent));
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell3);
        PdfPCell cell4= new PdfPCell(new Phrase("120", fontContent));
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell4);
        PdfPCell cell5= new PdfPCell(new Phrase("40", fontContent));
        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell5);
        PdfPCell cell6= new PdfPCell(new Phrase("40", fontContent));
        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell6);
        PdfPCell cell7= new PdfPCell(new Phrase("40", fontContent));
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell7);
        PdfPCell cell8= new PdfPCell(new Phrase("40", fontContent));
        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell8);
        tableXf.addCell(cell8);
        PdfPCell cell9= new PdfPCell(new Phrase(" ", fontContent));
        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell9);
        PdfPCell cell10= new PdfPCell(new Phrase(" ", fontContent));
        cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell10);
        PdfPCell cell11= new PdfPCell(new Phrase(" ", fontContent));
        cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableXf.addCell(cell11);
        document.add(tableXf);

        //foot
        PdfPTable tableFoot = new PdfPTable(7);
        tableFoot.setWidthPercentage(100);
        int tablewidthFoot[] = {5, 20, 10, 20, 10, 20, 15}; // percentage
        tableFoot.setWidths(tablewidthFoot);
        Phrase sh = new Phrase("审核：", fontContent);
        PdfPCell shCell = new PdfPCell(sh);
        shCell.setBorder(0);
        shCell.setFixedHeight(18);
        tableFoot.addCell(shCell);
        Phrase shmc = new Phrase(" ", fontContent);
        PdfPCell shmcCell = new PdfPCell(shmc);
        shmcCell.setBorder(0);
        shmcCell.setFixedHeight(18);
        tableFoot.addCell(shmcCell);
        Phrase yx = new Phrase("院系(盖章)：", fontContent);
        PdfPCell yxCell = new PdfPCell(yx);
        yxCell.setBorder(0);
        yxCell.setFixedHeight(18);
        tableFoot.addCell(yxCell);
        Phrase yxmc = new Phrase(" ", fontContent);
        PdfPCell yxmcCell = new PdfPCell(yxmc);
        yxmcCell.setBorder(0);
        yxmcCell.setFixedHeight(18);
        tableFoot.addCell(yxmcCell);
        Phrase jwc = new Phrase("教务处(盖章)：", fontContent);
        PdfPCell jwcCell = new PdfPCell(jwc);
        jwcCell.setBorder(0);
        jwcCell.setFixedHeight(18);
        tableFoot.addCell(jwcCell);
        Phrase jwcmc = new Phrase(" ", fontContent);
        PdfPCell jwcmcCell = new PdfPCell(jwcmc);
        jwcmcCell.setBorder(0);
        jwcmcCell.setFixedHeight(18);
        tableFoot.addCell(jwcmcCell);
        Phrase rq = new Phrase("打印日期："+format.format(new Date()), fontContent);
        PdfPCell rqCell = new PdfPCell(rq);
        rqCell.setBorder(0);
        rqCell.setFixedHeight(18);
        tableFoot.addCell(rqCell);
        document.add(tableFoot);

        document.add(new Chunk().setLocalDestination("1"));
        document.close();
    }
}