class Solution
{
public:
    bool containsDuplicate(vector<int> &nums)
    {
        set<int> st;
        for (int x : nums)
        {
            if (st.find(x) == st.end())
                st.insert(x);
            else
                return true;
        }
        return false;
    }
};