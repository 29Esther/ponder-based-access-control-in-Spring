package com.ecs235.ponder;

/* Generated By:JJTree: Do not edit this line. ASTType.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTType extends SimpleNode {
  public ASTType(int id) {
    super(id);
  }

  public ASTType(Ponder p, int id) {
    super(p, id);
  }

  private String name;

  public void setName(String n) {
    name = n;
  }

  public String toString() {
    return "Type: " + name;
  }
}
/* JavaCC - OriginalChecksum=fa183af85fa57aeb5f7be6e7324cd284 (do not edit this line) */
