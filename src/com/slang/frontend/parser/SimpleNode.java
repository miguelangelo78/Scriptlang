/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=NodeSetter,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.slang.frontend.parser;

import java.util.Arrays;

import com.slang.utils.Utils;
import com.slang.utils.dbg.Dbg;

public
class SimpleNode extends NodeSetter implements Node {

  protected Node parent;
  protected Node[] children;
  protected int id;
  protected Object value;
  protected ScriptlangParser parser;
  protected Token firstToken;
  protected Token lastToken;

  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(ScriptlangParser p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    if(children[i] == null) {
      throw new UnsupportedOperationException("(@Legal) Node #" + i + " is null.");
    }
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) { this.value = value; }
  public Object jjtGetValue() { return value; }

  public Token jjtGetFirstToken() { return firstToken; }
  public void jjtSetFirstToken(Token token) { this.firstToken = token; }
  public Token jjtGetLastToken() { return lastToken; }
  public void jjtSetLastToken(Token token) { this.lastToken = token; }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() {
	String tmp = ScriptlangParserTreeConstants.jjtNodeName[id];
    return tmp.substring(1) + 
    		((thisNode != null && 
    		  thisNode.name != Utils.NULLSTR &&
    		  thisNode.isNodeLeaf()) ? " (" + thisNode.name + ")" : "");
  }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
	  System.out.println(dumpStr(prefix));
  }
  
  public String dumpStr(String prefix) {
	  String strBuild = "\n" + toString(prefix);
	  if (children != null) {
		  for (int i = 0; i < children.length; ++i) {
			  SimpleNode n = (SimpleNode)children[i];
			  if (n != null) {
				  strBuild += n.dumpStr(prefix + "   ");
			  }
		  }
	  }
	  return strBuild;
  }

  public int getId() {
    return id;
  }

  @Override
  public Node legalizeAllChildren(Node parent, int astDepth) {
	  int childCount = jjtGetNumChildren();
	  String debugSpacingStr = "";
	  
	  if(astDepth > 0) {
		  char[] debugSpacing = new char[astDepth * 3];
		  Arrays.fill(debugSpacing, '_');
		  debugSpacingStr = new String(debugSpacing);
	  }
	  
	  String debugMsg = "(@" + this + " ch: " + childCount + " lvl: " + astDepth + ")";
	  Dbg.log("|" + debugSpacingStr + debugMsg);
	  
	  Node nodeLegalized = legalize(parent, astDepth);
	  if(nodeLegalized == null)
		  throw new UnsupportedOperationException("Node '" + this + "' is invalid (not legal).");
	  
	  for(int i = 0; i < childCount; i++) {
		  /* Now legalize all children */
		  jjtGetChild(i).legalizeAllChildren(nodeLegalized, astDepth + 1);
	  }
	  
	  return nodeLegalized;
  }
  
  public Node legalize(Node parent, int astDepth) {
	  throw new UnsupportedOperationException("Legal method UNIMPLEMENTED @ Node '" + this + "' & Parent '" + parent + "'");  
  }
}

/* JavaCC - OriginalChecksum=c1ef9ad04ba624833899d4f648bdfaf4 (do not edit this line) */
