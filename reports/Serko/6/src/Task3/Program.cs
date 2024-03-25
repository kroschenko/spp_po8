
using System.Text;
using System.Text.RegularExpressions;

interface IEncryptionStrategy
{
    string Encrypt(string text);
}

class RemoveVowelsEncryptionStrategy : IEncryptionStrategy
{
    public string Encrypt(string text)
    {
        return Regex.Replace(text, "[aeiouAEIOU]", "");
    }
}

class ShiftEncryptionStrategy : IEncryptionStrategy
{
    private int shift; 

    public ShiftEncryptionStrategy(int shift)
    {
        this.shift = shift;
    }

    public string Encrypt(string text)
    {
        StringBuilder encryptedText = new StringBuilder();
        foreach (char c in text)
        {
            if (char.IsLetter(c))
            {
                char shiftedChar = (char)(c + shift);
                if ((char.IsLower(c) && shiftedChar > 'z') || (char.IsUpper(c) && shiftedChar > 'Z'))
                {
                    shiftedChar = (char)(c - (26 - shift));
                }
                encryptedText.Append(shiftedChar);
            }
            else
            {
                encryptedText.Append(c);
            }
        }
        return encryptedText.ToString();
    }
}

class XOREncryptionStrategy : IEncryptionStrategy
{
    private string key;

    public XOREncryptionStrategy(string key)
    {
        this.key = key;
    }

    public string Encrypt(string text)
    {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.Length; i++)
        {
            encryptedText.Append((char)(text[i] ^ key[i % key.Length]));
        }
        return encryptedText.ToString();
    }
}

class TextFileEncryptor
{
    private IEncryptionStrategy encryptionStrategy;

    public TextFileEncryptor(IEncryptionStrategy encryptionStrategy)
    {
        this.encryptionStrategy = encryptionStrategy;
    }

    public void EncryptFile(string inputFile, string outputFile)
    {
        string text = File.ReadAllText(inputFile);
        string encryptedText = encryptionStrategy.Encrypt(text);
        File.WriteAllText(outputFile, encryptedText);
    }
}

class Program
{
    static void Main(string[] args)
    {

        IEncryptionStrategy strategy = new RemoveVowelsEncryptionStrategy(); 
        TextFileEncryptor encryptor = new TextFileEncryptor(strategy);

        encryptor.EncryptFile("input.txt", "output2.txt");
    }
}
