FROM node:latest as build

WORKDIR /usr/local/app
COPY . /usr/local/app

RUN npm install
RUN npm run build --prod=true


FROM nginx:alpine
COPY --from=build /usr/local/app/dist/eurovision-frontend /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
