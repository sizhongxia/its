/**
 * Created by sizho on 2017-5-8.
 */

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorTool {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = false;
        String genCfg = "./mybatis/mybatis-builder.xml";
        File configFile = new File(MyBatisGeneratorTool.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(new ProgressCallback() {
                @Override
                public void introspectionStarted(int i) {
                    System.out.println("introspectionStarted:" + i);
                }

                @Override
                public void generationStarted(int i) {
                    System.out.println("generationStarted:" + i);
                }

                @Override
                public void saveStarted(int i) {
                    System.out.println("saveStarted:" + i);
                }

                @Override
                public void startTask(String s) {
                    System.out.println("startTask:" + s);
                }

                @Override
                public void done() {
                    System.out.println("done");
                }

                @Override
                public void checkCancel() throws InterruptedException {
                    System.out.println("checkCancel");
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}