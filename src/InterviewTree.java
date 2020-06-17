import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: InterviewTree
 * @Author: 邹双双
 * Date: 2020/6/17 11:20
 * @Description:
 */
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
public class InterviewTree {
    public boolean isCompleteTree(TreeNode root){
        if (root == null){
            return true;
        }
        boolean isSecondStep = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (!isSecondStep){
                if (cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if (cur.left == null && cur.right != null){
                    return false;
                }else if (cur.left != null && cur.right == null){
                    isSecondStep = true;
                    queue.offer(cur.left);
                }else {
                    isSecondStep = true;
                }
            }else {
                if (cur.left != null || cur.right != null){
                    return false;
                }

            }


        }
        return true;
    }
    public static void main(String[] args) {

    }
}
