package org.talend.designer.codegen.translators.data_quality.matching.patternmatching;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPatternExtractEndJava
{
  protected static String nl;
  public static synchronized TPatternExtractEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPatternExtractEndJava result = new TPatternExtractEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "_NB_LINE\", nb_line_";
  protected final String TEXT_4 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_5 = "_NB_LINE_OK\", nb_line_ok_";
  protected final String TEXT_6 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_7 = "_NB_LINE_REJECT\", nb_line_reject_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
		}
	}

    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
