Node buildTree(int inord[], int level[])
    {
        //your code here
        Node root = null;
       return buildTreeUtil(root, inord, level, 0, inord.length - 1);
    }
      Node buildTreeUtil(Node root, int[] inorder, int[] level, int inStart, int inEnd){
       if(inStart > inEnd)
           return null;
       boolean found = false;
       int index=0;
       if(inStart == inEnd)
           return new Node(inorder[inStart]);
       for(int i=0; i<level.length - 1; i++){
           int data = level[i];
           for(int j=inStart; j<inEnd; j++){
               if(inorder[j] == data){
                   root = new Node(data);
                   index = j;
                   found = true;
                   break;
               }
           }
           if(found)
               break;
       }
       root.setLeft(buildTreeUtil(root, inorder, level, inStart, index - 1));
       root.setRight(buildTreeUtil(root, inorder, level, index + 1, inEnd));
       return root;
   }