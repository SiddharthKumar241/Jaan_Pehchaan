# 🤝 Social Network Friend Suggester

🧑‍🤝‍🧑 A Java-powered friend recommender for your social circle — smart suggestions, mutual vibes & CLI magic! ⚡💬

---

## 🚀 Features

- Add users to the network  
- Create friendships between users  
- Get smart friend suggestions based on **mutual connections**  
- Interactive **menu-based CLI**  
- Fun console outputs with emoji & color support 🎨

---

## 🛠️ Technologies Used

- Java  
- HashMap + HashSet  
- CLI-based interaction  
- ANSI escape codes for colored output  
- Sleep-based text animation (Thread.sleep)

---

## 📸 Preview

**Initial Friendship**


<img width="708" height="248" alt="Screenshot 2025-07-27 171454" src="https://github.com/user-attachments/assets/f66e0ae7-e67b-4567-b789-dcda803a46ce" />

**Adding User and Friendship**


<img width="701" height="556" alt="Screenshot 2025-07-27 171502" src="https://github.com/user-attachments/assets/ba9312be-e1b8-4bf0-ad7d-536d6b9d3daf" />


**Show Users and Friend Suggestions**

<img width="659" height="888" alt="Screenshot 2025-07-27 171520" src="https://github.com/user-attachments/assets/b50e1023-4714-45ef-b0c9-9872c46161e9" />


**Show Friend And Terminate**

<img width="560" height="543" alt="Screenshot 2025-07-27 171531" src="https://github.com/user-attachments/assets/d6bf2cdc-2697-4e2d-96eb-be784ed6d3b1" />


Welcome **Siddharth**! Let's manage your friend network.

Add user

Add friendship

Suggest friends

Show users

Show friends

Exit
Choose: 3
Suggest friends for: Siddharth
Friend suggestions for Siddharth:

Siddharth (2 common friend(s))

Ayushi (1 common friend(s))


---

## 📦 How to Run

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/SocialNetworkFriendSuggester.git
   cd SocialNetworkFriendSuggester

2. **Compile the Java file**
   ```bash
   javac SocialNetworkFriendSuggester.java

3. **Run the program**
   ```bash
   java SocialNetworkFriendSuggester

🧠 How It Works
The network is represented using a Map<String, Set<String>>.

Friend suggestions are calculated by finding mutual friends.

Users and friendships are stored in memory using HashSet and HashMap.

👥 Sample Users
Siddharth

Yash

Aditya

Ananya

Vedansh

Lakshya

Aditi

Ayushi

Manya

📝 License
This project is licensed under the MIT License.

✨ Credits

Siddharth Kumar
