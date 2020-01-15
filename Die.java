
/**
 * Rolls a die and returns the value. 
 *
 * @author Teddy Bryant
 * @version 2019-1-15
 */
public class Die
{
    private int result;
    public int roll()
    {
        result = ((int) (Math.random() * 6) + 1);
        return result;
    }
    
    public int getResult()
    {
        return result;
    }
}
