#include <iostream>
#include <stack>
#include <string>

int main() {
    std::string input;
    std::cin >> input;

    std::stack<char> stack;
    std::stack<int> sumStack;

    bool isValid = true;
    int result = 0;

    for (size_t i = 0; i < input.length(); ++i) {
        char c = input[i];

        if (c == '(' || c == '[') {
            stack.push(c);
            sumStack.push(0); // 초기값으로 0을 푸시
        } else {
            if (stack.empty()) {
                isValid = false;
                break;
            }

            char openBracket = stack.top();
            stack.pop();
            int innerSum = sumStack.top();
            sumStack.pop();

            if ((c == ')' && openBracket != '(') || (c == ']' && openBracket != '[')) {
                isValid = false;
                break;
            }

            int value = (c == ')') ? 2 : 3;
            int calculatedValue = value * (innerSum != 0 ? innerSum : 1);

            if (!sumStack.empty()) {
                sumStack.top() += calculatedValue;
            } else {
                result += calculatedValue;
            }
        }
    }

    if (!isValid || !stack.empty()) {
        std::cout << 0 << std::endl;
    } else {
        std::cout << result << std::endl;
    }

    return 0;
}
