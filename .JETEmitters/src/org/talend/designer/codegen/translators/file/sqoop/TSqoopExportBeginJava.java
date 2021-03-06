package org.talend.designer.codegen.translators.file.sqoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSqoopExportBeginJava
{
  protected static String nl;
  public static synchronized TSqoopExportBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqoopExportBeginJava result = new TSqoopExportBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + NL + "class SqoopAdditionalArgumentParser_";
  protected final String TEXT_33 = " {" + NL + "" + NL + "    public String[] parse(String command) {" + NL + "        final char QUOTE = '\\\"';" + NL + "        final char SINGLEQUOTE = '\\'';" + NL + "        final char SPACE = ' ';" + NL + "        final char BACKSLASH = '\\\\';" + NL + "        java.util.List<String> list = new java.util.ArrayList<String>();" + NL + "        if (command == null) {" + NL + "            return null;" + NL + "        }" + NL + "" + NL + "        StringBuilder sb = new StringBuilder();" + NL + "        char[] chars = command.trim().toCharArray();" + NL + "        boolean backslash = true;" + NL + "        boolean withinString = false;" + NL + "        for (char c : chars) {" + NL + "            switch (c) {" + NL + "            case SPACE:" + NL + "                if (!withinString) {" + NL + "                    if (sb.toString().trim().length() > 0) {" + NL + "                        list.add(sb.toString());" + NL + "                        sb = new StringBuilder();" + NL + "                    }" + NL + "                } else {" + NL + "                    sb.append(c);" + NL + "                }" + NL + "                break;" + NL + "            case SINGLEQUOTE:" + NL + "                if (!withinString) {" + NL + "                    withinString = true;" + NL + "                } else {" + NL + "                    withinString = false;" + NL + "                }" + NL + "                break;" + NL + "            case QUOTE:" + NL + "                if (backslash && !withinString) {" + NL + "                    withinString = true;" + NL + "                }" + NL + "                if (backslash && withinString) {" + NL + "                    withinString = false;" + NL + "                }" + NL + "                break;" + NL + "            case BACKSLASH:" + NL + "                if (!backslash) {" + NL + "                    backslash = true;" + NL + "                } else {" + NL + "                    backslash = false;" + NL + "                }" + NL + "                break;" + NL + "            default:" + NL + "                sb.append(c);" + NL + "            }" + NL + "        }" + NL + "        if (sb.toString().trim().length() > 0) {" + NL + "            list.add(sb.toString());" + NL + "        }" + NL + "        return list.toArray(new String[list.size()]);" + NL + "    }" + NL + "}" + NL + "SqoopAdditionalArgumentParser_";
  protected final String TEXT_34 = " parser_";
  protected final String TEXT_35 = " = new SqoopAdditionalArgumentParser_";
  protected final String TEXT_36 = "();" + NL + "" + NL + "//call the cmd part" + NL + "Runtime runtime_";
  protected final String TEXT_37 = " = Runtime.getRuntime();" + NL;
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_40 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = "; ";
  protected final String TEXT_45 = NL + "\t" + NL + "" + NL + "String[] cmd_";
  protected final String TEXT_46 = " = new String[] {\"sqoop\", \"export\"";
  protected final String TEXT_47 = " " + NL + "\t\t\t,\"-D";
  protected final String TEXT_48 = "=\"+";
  protected final String TEXT_49 = NL + ",";
  protected final String TEXT_50 = NL + NL + ", \"--connect\", ";
  protected final String TEXT_51 = ", \"--table\", ";
  protected final String TEXT_52 = " , \"--username\", ";
  protected final String TEXT_53 = NL + "\t, \"--password-file\", ";
  protected final String TEXT_54 = NL + "\t, \"--password\", decryptedPassword_";
  protected final String TEXT_55 = NL + ", \"--export-dir\", ";
  protected final String TEXT_56 = ",\"--connection-manager\",\"org.apache.sqoop.teradata.TeradataConnManager\"";
  protected final String TEXT_57 = ", \"--verbose\"";
  protected final String TEXT_58 = ", \"--direct\"";
  protected final String TEXT_59 = ", \"--as-sequencefile\"";
  protected final String TEXT_60 = ", \"--mysql-delimiters\"";
  protected final String TEXT_61 = ", \"--num-mappers\", ";
  protected final String TEXT_62 = ", \"--batch\"";
  protected final String TEXT_63 = ", \"--clear-staging-table\"";
  protected final String TEXT_64 = ", \"--call\", ";
  protected final String TEXT_65 = ", \"--staging-table\", ";
  protected final String TEXT_66 = ", \"--update-mode\", \"";
  protected final String TEXT_67 = "\"";
  protected final String TEXT_68 = NL + "\t\t,\"--update-key\"";
  protected final String TEXT_69 = NL + "\t\t\t\t,";
  protected final String TEXT_70 = NL + "\t\t\t\t+ \",\" + ";
  protected final String TEXT_71 = " " + NL + "            ,\"";
  protected final String TEXT_72 = "\", ";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = " " + NL + "            ,\"";
  protected final String TEXT_75 = "\" ";
  protected final String TEXT_76 = NL + "\t\t,\"--map-column-java\"";
  protected final String TEXT_77 = NL + "\t\t\t\t,";
  protected final String TEXT_78 = " + \"=\" + ";
  protected final String TEXT_79 = NL + "\t\t\t\t+\",\" + ";
  protected final String TEXT_80 = " + \"=\" + ";
  protected final String TEXT_81 = NL + "};" + NL + "" + NL + "String[] additionalArgs_";
  protected final String TEXT_82 = " = parser_";
  protected final String TEXT_83 = ".parse(";
  protected final String TEXT_84 = ");" + NL + "cmd_";
  protected final String TEXT_85 = " = (String[]) org.apache.commons.lang.ArrayUtils.addAll(cmd_";
  protected final String TEXT_86 = ", additionalArgs_";
  protected final String TEXT_87 = ");" + NL;
  protected final String TEXT_88 = NL + "java.lang.StringBuilder stringBuilder_";
  protected final String TEXT_89 = " = new java.lang.StringBuilder();" + NL + "for(String parameter_";
  protected final String TEXT_90 = " : cmd_";
  protected final String TEXT_91 = ") {" + NL + "\tstringBuilder_";
  protected final String TEXT_92 = ".append(parameter_";
  protected final String TEXT_93 = ");" + NL + "\tstringBuilder_";
  protected final String TEXT_94 = ".append(\" \");" + NL + "}" + NL + "log.info(\"";
  protected final String TEXT_95 = " - execute sqoop command: \" + stringBuilder_";
  protected final String TEXT_96 = ".toString());";
  protected final String TEXT_97 = NL + NL + "Process ps_";
  protected final String TEXT_98 = " = null;" + NL + "java.lang.StringBuilder sb_";
  protected final String TEXT_99 = " = null;" + NL + "" + NL + "try {" + NL + "\tps_";
  protected final String TEXT_100 = " = runtime_";
  protected final String TEXT_101 = ".exec(cmd_";
  protected final String TEXT_102 = ");" + NL + "\tbyte[] byteArray_";
  protected final String TEXT_103 = " = new byte[1024];" + NL + "\tint len_";
  protected final String TEXT_104 = " = 0;" + NL + "\t" + NL + "\tjava.io.InputStream errorStream_";
  protected final String TEXT_105 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_106 = ".getErrorStream());" + NL + "\tsb_";
  protected final String TEXT_107 = " = new java.lang.StringBuilder();" + NL + "\twhile ((len_";
  protected final String TEXT_108 = " = errorStream_";
  protected final String TEXT_109 = ".read(byteArray_";
  protected final String TEXT_110 = ")) != -1) {" + NL + "\t    String line_";
  protected final String TEXT_111 = " = new String(byteArray_";
  protected final String TEXT_112 = ", 0, len_";
  protected final String TEXT_113 = ", \"ISO-8859-1\");";
  protected final String TEXT_114 = NL + "\t        System.err.println(line_";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "\t    sb_";
  protected final String TEXT_117 = ".append(line_";
  protected final String TEXT_118 = ");" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_119 = "_ERROR_MESSAGE\", sb_";
  protected final String TEXT_120 = ".toString());" + NL + "\t";
  protected final String TEXT_121 = NL + "\t\tlog.error(\"";
  protected final String TEXT_122 = " - \" + sb_";
  protected final String TEXT_123 = ".toString());" + NL + "\t";
  protected final String TEXT_124 = NL + "\t" + NL + "\tbyteArray_";
  protected final String TEXT_125 = " = new byte[1024];" + NL + "\tlen_";
  protected final String TEXT_126 = " = 0;" + NL + "\tjava.io.InputStream inputStream_";
  protected final String TEXT_127 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_128 = ".getInputStream());" + NL + "\tsb_";
  protected final String TEXT_129 = " = new java.lang.StringBuilder();" + NL + "\twhile ((len_";
  protected final String TEXT_130 = " = inputStream_";
  protected final String TEXT_131 = ".read(byteArray_";
  protected final String TEXT_132 = ")) != -1) {" + NL + "\t    String line_";
  protected final String TEXT_133 = " = new String(byteArray_";
  protected final String TEXT_134 = ", 0, len_";
  protected final String TEXT_135 = ", \"ISO-8859-1\");";
  protected final String TEXT_136 = NL + "\t        System.out.println(line_";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t    sb_";
  protected final String TEXT_139 = ".append(line_";
  protected final String TEXT_140 = ");" + NL + "\t}" + NL + "} catch (Exception e) {";
  protected final String TEXT_141 = NL + "\t\tthrow e;";
  protected final String TEXT_142 = NL + "\t\tSystem.err.println(e.getMessage());" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t\tlog.error(\"";
  protected final String TEXT_144 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_145 = "\t" + NL + "}" + NL + "" + NL + "" + NL + "\tint result_";
  protected final String TEXT_146 = " = ps_";
  protected final String TEXT_147 = ".waitFor();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_148 = "_EXIT_CODE\", result_";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\t\tif(ps_";
  protected final String TEXT_151 = ".exitValue()>0) {" + NL + "\t\t\tthrow new Exception(\"The Sqoop export has failed. Please check the logs.\");" + NL + "\t\t}";
  protected final String TEXT_152 = NL + NL + "if(sb_";
  protected final String TEXT_153 = "!=null) {" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_154 = "_OUTPUT_MESSAGE\", sb_";
  protected final String TEXT_155 = ".toString());" + NL + "\t";
  protected final String TEXT_156 = NL + "\t\tlog.info(\"";
  protected final String TEXT_157 = " - \" + sb_";
  protected final String TEXT_158 = ".toString());" + NL + "\t";
  protected final String TEXT_159 = NL + "}";
  protected final String TEXT_160 = NL + "\t";
  protected final String TEXT_161 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_162 = ");" + NL + "\t" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_163 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_164 = NL + "\t\tString username_";
  protected final String TEXT_165 = " = ";
  protected final String TEXT_166 = ";" + NL + "\t\tif(username_";
  protected final String TEXT_167 = "!=null && !\"\".equals(username_";
  protected final String TEXT_168 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_169 = ");" + NL + "\t\t}";
  protected final String TEXT_170 = NL + "\t" + NL + "\torg.apache.hadoop.conf.Configuration configuration_";
  protected final String TEXT_171 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconfiguration_";
  protected final String TEXT_172 = ".set(\"";
  protected final String TEXT_173 = "\", ";
  protected final String TEXT_174 = ");";
  protected final String TEXT_175 = NL + "\t\tconfiguration_";
  protected final String TEXT_176 = ".set(\"mapreduce.job.map.output.collector.class\", \"org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t    configuration_";
  protected final String TEXT_177 = ".set(\"mapreduce.job.reduce.shuffle.consumer.plugin.class\", \"org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_178 = NL + "    \tconfiguration_";
  protected final String TEXT_179 = ".set(\"mapreduce.framework.name\", \"yarn\");" + NL + "    \tconfiguration_";
  protected final String TEXT_180 = ".set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_183 = ".set(\"mapreduce.jobhistory.address\", ";
  protected final String TEXT_184 = ");" + NL + "\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_186 = ".set(\"yarn.resourcemanager.scheduler.address\", ";
  protected final String TEXT_187 = ");";
  protected final String TEXT_188 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_189 = ".set(\"yarn.app.mapreduce.am.staging-dir\", ";
  protected final String TEXT_190 = ");";
  protected final String TEXT_191 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_192 = ".set(\"mapreduce.app-submission.cross-platform\",\"true\");";
  protected final String TEXT_193 = NL + "    \t\tconfiguration_";
  protected final String TEXT_194 = ".set(\"yarn.application.classpath\",\"/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_195 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_196 = ".set(\"mapreduce.application.classpath\",\"$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_197 = ".set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");";
  protected final String TEXT_198 = NL + "    \t\t//set default yarn classpath with environment variable" + NL + "    \t\tconfiguration_";
  protected final String TEXT_199 = ".set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_200 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_201 = ".set(\"mapreduce.app-submission.cross-platform\",\"true\");";
  protected final String TEXT_202 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_203 = ".set(\"mapreduce.map.memory.mb\", ";
  protected final String TEXT_204 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_205 = ".set(\"mapreduce.reduce.memory.mb\", ";
  protected final String TEXT_206 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_207 = ".set(\"yarn.app.mapreduce.am.resource.mb\", ";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = NL + "\t\tconfiguration_";
  protected final String TEXT_210 = ".set(\"mapred.job.tracker\", ";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "        configuration_";
  protected final String TEXT_213 = ".set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_214 = ");" + NL + "        configuration_";
  protected final String TEXT_215 = ".set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_216 = ");";
  protected final String TEXT_217 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_218 = ".set(";
  protected final String TEXT_219 = " ,";
  protected final String TEXT_220 = ");";
  protected final String TEXT_221 = NL + "\t\tconfiguration_";
  protected final String TEXT_222 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_223 = ");";
  protected final String TEXT_224 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_225 = ".set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_228 = ".set(\"yarn.resourcemanager.principal\", ";
  protected final String TEXT_229 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_230 = ".set(\"mapreduce.jobhistory.principal\", ";
  protected final String TEXT_231 = ");";
  protected final String TEXT_232 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_233 = ", ";
  protected final String TEXT_234 = ");";
  protected final String TEXT_235 = NL + "        configuration_";
  protected final String TEXT_236 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_237 = NL + "\t//check whether we can connect to the fs?" + NL + "\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_238 = " = org.apache.hadoop.fs.FileSystem.get(configuration_";
  protected final String TEXT_239 = ");" + NL + "\t" + NL + "\tcom.cloudera.sqoop.tool.SqoopTool sqoopTool_";
  protected final String TEXT_240 = " = com.cloudera.sqoop.tool.SqoopTool.getTool(\"export\");" + NL + "" + NL + "\tcom.cloudera.sqoop.SqoopOptions sqoopOptions_";
  protected final String TEXT_241 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_242 = ");" + NL + "\t" + NL + "\tsqoopOptions_";
  protected final String TEXT_243 = ".setConnectString(";
  protected final String TEXT_244 = "); // __CONNECTION__";
  protected final String TEXT_245 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_246 = ".setTableName(";
  protected final String TEXT_247 = ");";
  protected final String TEXT_248 = NL + "\tsqoopOptions_";
  protected final String TEXT_249 = ".setExportDir(";
  protected final String TEXT_250 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_251 = ".setUsername(";
  protected final String TEXT_252 = "); // __USERNAME__" + NL + "\t" + NL + "\t";
  protected final String TEXT_253 = NL + "\t\t";
  protected final String TEXT_254 = NL + "\t\t";
  protected final String TEXT_255 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_256 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_257 = ");";
  protected final String TEXT_258 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_259 = " = ";
  protected final String TEXT_260 = "; ";
  protected final String TEXT_261 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_262 = ".setPassword(decryptedPassword_";
  protected final String TEXT_263 = "); // __PASSWORD__" + NL + "\t";
  protected final String TEXT_264 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_265 = ".setPasswordFilePath(";
  protected final String TEXT_266 = ");" + NL + "\t\tsqoopOptions_";
  protected final String TEXT_267 = ".setPassword(org.apache.sqoop.util.CredentialsUtil.fetchPassword";
  protected final String TEXT_268 = "(sqoopOptions_";
  protected final String TEXT_269 = "));" + NL + "\t";
  protected final String TEXT_270 = NL + NL + "\t";
  protected final String TEXT_271 = "sqoopOptions_";
  protected final String TEXT_272 = ".setDirectMode(true);";
  protected final String TEXT_273 = NL + "\t";
  protected final String TEXT_274 = "sqoopOptions_";
  protected final String TEXT_275 = ".setNumMappers(Integer.valueOf(";
  protected final String TEXT_276 = "));";
  protected final String TEXT_277 = NL + "\t";
  protected final String TEXT_278 = "sqoopOptions_";
  protected final String TEXT_279 = ".setBatchMode(true);";
  protected final String TEXT_280 = NL + "\t";
  protected final String TEXT_281 = "sqoopOptions_";
  protected final String TEXT_282 = ".setClearStagingTable(true);";
  protected final String TEXT_283 = NL + "\t";
  protected final String TEXT_284 = "sqoopOptions_";
  protected final String TEXT_285 = ".setCall(";
  protected final String TEXT_286 = ");";
  protected final String TEXT_287 = NL + "\t";
  protected final String TEXT_288 = "sqoopOptions_";
  protected final String TEXT_289 = ".setStagingTableName(";
  protected final String TEXT_290 = ");";
  protected final String TEXT_291 = NL + "\t";
  protected final String TEXT_292 = "sqoopOptions_";
  protected final String TEXT_293 = ".setUpdateMode(com.cloudera.sqoop.SqoopOptions.";
  protected final String TEXT_294 = ");";
  protected final String TEXT_295 = NL + "\t";
  protected final String TEXT_296 = NL + "\t\t\t\tStringBuilder sb_update_";
  protected final String TEXT_297 = " = new StringBuilder();" + NL + "\t";
  protected final String TEXT_298 = NL + "\t\t\t\t\t\tsb_update_";
  protected final String TEXT_299 = ".append(";
  protected final String TEXT_300 = ");" + NL + "\t";
  protected final String TEXT_301 = NL + "\t\t\t\t\t\tsb_update_";
  protected final String TEXT_302 = ".append(\",\" + ";
  protected final String TEXT_303 = ");" + NL + "\t";
  protected final String TEXT_304 = NL + "\t\t\t\tsqoopOptions_";
  protected final String TEXT_305 = ".setUpdateKeyCol(sb_update_";
  protected final String TEXT_306 = ".toString());" + NL + "\t";
  protected final String TEXT_307 = NL + "\t\t\t\tStringBuilder sb_java_";
  protected final String TEXT_308 = " = new StringBuilder();" + NL + "\t";
  protected final String TEXT_309 = NL + "\t\t\t\t\t\tsb_java_";
  protected final String TEXT_310 = ".append(";
  protected final String TEXT_311 = " + \"=\" + ";
  protected final String TEXT_312 = ");" + NL + "\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\tsb_java_";
  protected final String TEXT_314 = ".append(\",\" + ";
  protected final String TEXT_315 = " + \"=\" + ";
  protected final String TEXT_316 = ");" + NL + "\t";
  protected final String TEXT_317 = NL + "\t\t\t\tsqoopOptions_";
  protected final String TEXT_318 = ".setMapColumnJava(sb_java_";
  protected final String TEXT_319 = ".toString());" + NL + "\t";
  protected final String TEXT_320 = NL + "\tjava.util.Properties additionalProperties_";
  protected final String TEXT_321 = " = new java.util.Properties();";
  protected final String TEXT_322 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_323 = ".put(";
  protected final String TEXT_324 = ", \"\"+";
  protected final String TEXT_325 = ".codePointAt(0)); ";
  protected final String TEXT_326 = " " + NL + "\t\t\t\tadditionalProperties_";
  protected final String TEXT_327 = ".put(";
  protected final String TEXT_328 = ", ";
  protected final String TEXT_329 = "); ";
  protected final String TEXT_330 = NL + "\tsqoopOptions_";
  protected final String TEXT_331 = ".loadProperties(additionalProperties_";
  protected final String TEXT_332 = ");" + NL + "\torg.apache.sqoop.Sqoop sqoop_";
  protected final String TEXT_333 = " = new org.apache.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_334 = ", configuration_";
  protected final String TEXT_335 = ", sqoopOptions_";
  protected final String TEXT_336 = ");" + NL + "" + NL + "\ttry {" + NL + "\t\tint result_";
  protected final String TEXT_337 = " = sqoop_";
  protected final String TEXT_338 = ".run(null);" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_339 = "_EXIT_CODE\", result_";
  protected final String TEXT_340 = ");" + NL + "\t\tif(result_";
  protected final String TEXT_341 = " != 0) {";
  protected final String TEXT_342 = NL + "\t\t\t\tthrow new Exception(\"The Sqoop export job has failed. Please check the logs.\");";
  protected final String TEXT_343 = NL + "\t\t\t\tSystem.err.println(\"The Sqoop export job has failed. Please check the logs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_344 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_345 = " - The Sqoop export job has failed. Please check the logs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_346 = NL + "\t\t}" + NL + "\t} catch (Exception e) {";
  protected final String TEXT_347 = NL + "\t\t\tthrow e;";
  protected final String TEXT_348 = NL + "\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_350 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_351 = NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_352 = NL + "String currentClientPathSeparator_";
  protected final String TEXT_353 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_354 = "!=null) {" + NL + "\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_355 = ");" + NL + "\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_356 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_357 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_358 = "!=null) {" + NL + "\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_359 = ");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_360 = "\", null);" + NL + "} else {" + NL + "\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    boolean useCommandLine = "true".equals(ElementParameterParser.getValue(node,"__USE_COMMANDLINE__"));
    
    if(useCommandLine) {

    stringBuffer.append(TEXT_30);
    
   String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
   String table = ElementParameterParser.getValue(node,"__TABLE__");
   String username = ElementParameterParser.getValue(node,"__USERNAME__");
   String exportDir = ElementParameterParser.getValue(node,"__EXPORT_DIR__");
   boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
   boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
   boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
   boolean mysqlDelimiters = "true".equals(ElementParameterParser.getValue(node,"__MYSQL_DELIMITERS__"));
   boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
   String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
   String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
   List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_ARGUMENTS__");
   boolean isUseSpeedParallel = "true".equals(ElementParameterParser.getValue(node,"__USE_SPEED_PARALLEL__"));
	List<Map<String,String>> specificParams= (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__SPECIFIC_PARAMS__");
	boolean isUseAdditionParams = "true".equals(ElementParameterParser.getValue(node,"__USE_ADDITION_PARAM__"));
	String specificAdditionParams=ElementParameterParser.getValue(node,"__SPECIFIC_ADDITION_PARAM__");

	boolean callProcStock = "true".equals(ElementParameterParser.getValue(node, "__CALL_PROC_STOC__"));
	String procStock = ElementParameterParser.getValue(node, "__PROC_STOC__");
	boolean useBatchMode = "true".equals(ElementParameterParser.getValue(node, "__USE_BATCH_MODE__"));
	boolean clearStagingTable = "true".equals(ElementParameterParser.getValue(node, "__CLEAR_STAGING_TABLE__"));
	boolean defineStagingTable = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STAGING_TABLE__"));
	String stagingTable = ElementParameterParser.getValue(node, "__STAGING_TABLE__");
	boolean useColumnForUpdate = "true".equals(ElementParameterParser.getValue(node, "__USE_COLUMN_FOR_UPDATE__"));
	boolean defineUpdateMode = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_UPDATE_MODE__"));
	String updateMode = ElementParameterParser.getValue(node, "__UPDATE_MODE__");
	String additionalCommandLineArguments = ElementParameterParser.getValue(node,"__ADDITIONAL_COMMANDLINE_ARGUMENTS__");
	boolean overrideJavaMapping = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_JAVA_MAPPING__"));
	boolean passwordStoredInFile = "true".equals(ElementParameterParser.getValue(node, "__PASSWORD_STORED_IN_FILE__"));

	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_38);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
boolean isNull=false; 
if(isUseSpeedParallel && specificParams!=null){
	boolean isFirstParam=true;
	for(Map<String,String> specificArg : specificParams){ 
		isNull=false; 
	 	if(specificArg.get("SPECIFIC_PARAM_VALUE")==null || "".equals(specificArg.get("SPECIFIC_PARAM_VALUE"))) { 
	 		isNull=true; 
	 	} 
	 	if(!isNull) { 

    stringBuffer.append(TEXT_47);
    stringBuffer.append(specificArg.get("SPECIFIC_PARAM"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(specificArg.get("SPECIFIC_PARAM_VALUE"));
     
		} 
	} 
} 
if(isUseSpeedParallel && isUseAdditionParams){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(specificAdditionParams);
    
}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(connection);
    if(!callProcStock){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(table);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(username);
    if(passwordStoredInFile) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append((String)ElementParameterParser.getValue(node, "__PASSWORD_FILE__"));
    } else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(exportDir);
    if(isUseSpeedParallel){
    stringBuffer.append(TEXT_56);
    }
    if(printLog && verbose){
    stringBuffer.append(TEXT_57);
    }
    if(direct && (!defineUpdateMode || "updateonly".equals(updateMode))){
    stringBuffer.append(TEXT_58);
    }
    if(fileFormat.equals("sequencefile")){
    stringBuffer.append(TEXT_59);
    }
    if(mysqlDelimiters){
    stringBuffer.append(TEXT_60);
    }
    if(useMappers){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(mappers);
    }
    if(useBatchMode){
    stringBuffer.append(TEXT_62);
    }
    if(clearStagingTable && !useColumnForUpdate && !callProcStock){
    stringBuffer.append(TEXT_63);
    }
    if(callProcStock){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(procStock);
    }
    if(defineStagingTable && !useColumnForUpdate && !callProcStock){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(stagingTable);
    }
    if(defineUpdateMode){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(updateMode);
    stringBuffer.append(TEXT_67);
    }
    
if(useColumnForUpdate && !callProcStock) {
	List<Map<String,String>> columnsForUpdate = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__COLUMN_FOR_UPDATE__");
	if(columnsForUpdate!=null && columnsForUpdate.size()>0) {

    stringBuffer.append(TEXT_68);
    
		boolean first = true;	
		for(Map<String,String> columnForUpdate : columnsForUpdate) {
			if(first) {
				first = false;

    stringBuffer.append(TEXT_69);
    stringBuffer.append(columnForUpdate.get("COLUMN_NAME"));
    
			} else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(columnForUpdate.get("COLUMN_NAME"));
    
			}	
		}
	}
}

if(additionalList != null){ 
    for(Map<String,String> additionalMap : additionalList){ 
        isNull=false; 
        if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
            isNull=true; 
        } 
        if(!isNull) { 

    stringBuffer.append(TEXT_71);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_73);
     
        } else { 

    stringBuffer.append(TEXT_74);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_75);
     
        } 
    } 
} 

if(overrideJavaMapping) {
	List<Map<String,String>> javaMappings = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__JAVA_TYPE_MAPPING__");
	if(javaMappings!=null && javaMappings.size()>0) {

    stringBuffer.append(TEXT_76);
    
		boolean first = true;	
		for(Map<String,String> javaMapping : javaMappings) {
			if(first) {
				first = false;

    stringBuffer.append(TEXT_77);
    stringBuffer.append(javaMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(javaMapping.get("JAVA_TYPE"));
    
			} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(javaMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(javaMapping.get("JAVA_TYPE"));
    
			}	
		}
	}
}

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(additionalCommandLineArguments);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
	    if(printLog){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
	    }

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
	    if(printLog){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
	    }

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_141);
    		
	} else {

    stringBuffer.append(TEXT_142);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    }
	}

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    		
	}

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    
    } else {

    
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	boolean isCustom = "CUSTOM".equals(distribution);
	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String jobtracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
	String exportDir = ElementParameterParser.getValue(node,"__EXPORT_DIR__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	boolean direct = "true".equals(ElementParameterParser.getValue(node,"__DIRECT__"));
	boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
	String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_JAVA__");

	String fsDefalutName = "fs.default.name";

	boolean useBatchMode = "true".equals(ElementParameterParser.getValue(node, "__USE_BATCH_MODE__"));
	boolean clearStagingTable = "true".equals(ElementParameterParser.getValue(node, "__CLEAR_STAGING_TABLE__"));
	boolean defineStagingTable = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STAGING_TABLE__"));
	String stagingTable = ElementParameterParser.getValue(node, "__STAGING_TABLE__");
    boolean useDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
	boolean callProcStock = "true".equals(ElementParameterParser.getValue(node, "__CALL_PROC_STOC__"));
	String procStock = ElementParameterParser.getValue(node, "__PROC_STOC__");
	boolean defineUpdateMode = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_UPDATE_MODE__"));
	String updateMode = ElementParameterParser.getValue(node, "__UPDATE_MODE__");
	boolean overrideJavaMapping = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_JAVA_MAPPING__"));
	boolean useColumnForUpdate = "true".equals(ElementParameterParser.getValue(node, "__USE_COLUMN_FOR_UPDATE__"));
	boolean passwordStoredInFile = "true".equals(ElementParameterParser.getValue(node, "__PASSWORD_STORED_IN_FILE__"));
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_160);
    
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_161);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
	if(isCustom || (!isCustom && (version!=null && "HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,HDP_2_2,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_4,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0,APACHE_2_4_0_EMR".contains(version)))) {
		String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    
	}

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_174);
    

	if(!isCustom && ("MAPR401".equals(version) || "MAPR410".equals(version))) {//set the default properties

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
	}
	
	boolean isKerberosAvailableHadoop2 = !isCustom && ("PIVOTAL_HD_2_0".equals(version) || "HDP_2_0".equals(version) || "HDP_2_1".equals(version) || "HDP_2_2".equals(version) || "Cloudera_CDH4_YARN".equals(version) || "Cloudera_CDH5".equals(version) || "Cloudera_CDH5_1".equals(version) || "Cloudera_CDH5_4".equals(version));
	boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(version) || "APACHE_2_4_0_EMR".equals(version) || "MAPR401".equals(version) || "MAPR410".equals(version) || isKerberosAvailableHadoop2;
	
	boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version) || "Cloudera_CDH4".equals(version) || "Cloudera_CDH5_1_MR1".equals(version));
	
	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_181);
    
		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
		if(setJobHistoryAddress) {
			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
			
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_184);
    
		}
		
		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
		if(setSchedulerAddress) {
			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_187);
    
		}
		boolean setStagingDirectory = "true".equals(ElementParameterParser.getValue(node, "__SET_STAGING_DIRECTORY__"));
		if(setStagingDirectory) {
			String stagingDirectory = ElementParameterParser.getValue(node, "__STAGING_DIRECTORY__");

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(stagingDirectory);
    stringBuffer.append(TEXT_190);
    
		}
		
		if(!isCustom && ("HDP_2_1".equals(version) || "HDP_2_2".equals(version) || "Cloudera_CDH5".equals(version) || "Cloudera_CDH5_1".equals(version) || "Cloudera_CDH5_4".equals(version) || "MAPR401".equals(version) || "MAPR410".equals(version) || "APACHE_2_4_0_EMR".equals(version) || "APACHE_2_4_0_EMR_0_13_1".equals(version))) {

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
		}
		
		if(!isCustom && "HDP_2_1".equals(version)) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
		} else if(!isCustom && "HDP_2_2".equals(version)) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
		} else {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
		}
		
		boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
		if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
		}
		
		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_208);
    
		}
	} else {

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(jobtracker);
    stringBuffer.append(TEXT_211);
    
	}
	
    if(!isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_216);
    
    }
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_220);
     
		}
	}
	if(useKrb) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
		boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
		String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
		String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_223);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_226);
    
		}
		
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");
			String jobHistoryPrincipal = ElementParameterParser.getValue(node, "__JOBHISTORY_PRINCIPAL__");

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(jobHistoryPrincipal);
    stringBuffer.append(TEXT_231);
    
		}

		if(useKeytab) {

    stringBuffer.append(TEXT_232);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_234);
    
		}
	}

    if (useDatanodeHostname) {
        
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
    }

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_244);
    	
	if(!callProcStock) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_247);
    
	}

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(exportDir);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_252);
    if(!passwordStoredInFile || !(("Cloudera_CDH5".equals(version) || "Cloudera_CDH5_1".equals(version) || "Cloudera_CDH5_4".equals(version) || "HDP_2_0".equals(version) || "HDP_2_1".equals(version) || "HDP_2_2".equals(version) || "PIVOTAL_HD_2_0".equals(version) || "APACHE_2_4_0_EMR".equals(version)))) {
    stringBuffer.append(TEXT_253);
    
		String passwordFieldName = "__PASSWORD__";
    	
    stringBuffer.append(TEXT_254);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_257);
    } else {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_260);
    }
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    } else {
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append((String)ElementParameterParser.getValue(node, "__PASSWORD_FILE__"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append("HDP_2_0".equals(version)?"FromFile":"");
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    if(direct && (!defineUpdateMode || "updateonly".equals(updateMode))){
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    }
    stringBuffer.append(TEXT_273);
    if(useMappers){
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(mappers);
    stringBuffer.append(TEXT_276);
    }
    stringBuffer.append(TEXT_277);
    if(useBatchMode){
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    }
    stringBuffer.append(TEXT_280);
    if(clearStagingTable && !useColumnForUpdate && !callProcStock){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    }
    stringBuffer.append(TEXT_283);
    if(callProcStock){
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(procStock);
    stringBuffer.append(TEXT_286);
    }
    stringBuffer.append(TEXT_287);
    if(defineStagingTable && !useColumnForUpdate && !callProcStock){
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(stagingTable);
    stringBuffer.append(TEXT_290);
    }
    stringBuffer.append(TEXT_291);
    if(!useColumnForUpdate && defineUpdateMode){
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append("updateonly".equals(updateMode)?"UpdateMode.UpdateOnly":"UpdateMode.AllowInsert");
    stringBuffer.append(TEXT_294);
    }
    stringBuffer.append(TEXT_295);
    
		if(useColumnForUpdate && !defineUpdateMode && !callProcStock) {
			List<Map<String,String>> columnsForUpdate = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__COLUMN_FOR_UPDATE__");
			if(columnsForUpdate!=null && columnsForUpdate.size()>0) {
	
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
				boolean first = true;	
				for(Map<String,String> columnForUpdate : columnsForUpdate) {
					if(first) {
						first = false;
	
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(columnForUpdate.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_300);
    
					} else {
	
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(columnForUpdate.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_303);
    
					}	
				}
	
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
			}
		}
		if(overrideJavaMapping) {
			List<Map<String,String>> javaMappings = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__JAVA_TYPE_MAPPING__");
			if(javaMappings!=null && javaMappings.size()>0) {
	
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    
				boolean first = true;	
				for(Map<String,String> javaMapping : javaMappings) {
					if(first) {
						first = false;
	
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(javaMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(javaMapping.get("JAVA_TYPE"));
    stringBuffer.append(TEXT_312);
    
					} else {
	
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(javaMapping.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(javaMapping.get("JAVA_TYPE"));
    stringBuffer.append(TEXT_316);
    
					}	
				}
	
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    
			}
		}
	
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
	if(passwordStoredInFile) {
		
	}
	if(additionalList != null){ 
		for(Map<String,String> additionalMap : additionalList){
			if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
				break; 
			}
			if(additionalMap.get("ADDITIONAL_ARGUMENT").contains("delimiters")) {
				

    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_325);
    
			} else {

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_329);
    
			}
		} 
	} 

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
			if(dieOnError) {

    stringBuffer.append(TEXT_342);
    
			} else {

    stringBuffer.append(TEXT_343);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    }
			}

    stringBuffer.append(TEXT_346);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_347);
    
		} else {

    stringBuffer.append(TEXT_348);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    }
		}

    stringBuffer.append(TEXT_351);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
    }
    

    return stringBuffer.toString();
  }
}
