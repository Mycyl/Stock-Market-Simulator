import os
from dotenv import load_dotenv

load_dotenv()

def getAPIKey():
    return os.environ.get("TOKEN")

if __name__ == "__main__":
    api_key = getAPIKey()
    if api_key:
        print(api_key)
    else:
        print("API key not found")